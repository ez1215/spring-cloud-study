package com.cloud.pay.service.impl;

import com.cloud.common.exception.BusinessException;
import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.GoodsVo;
import com.cloud.common.vo.OrderVo;
import com.cloud.common.vo.UserVo;
import com.cloud.pay.feign.GoodsFeignClient;
import com.cloud.pay.feign.OrderFeignClient;
import com.cloud.pay.feign.UserFeignClient;
import com.cloud.pay.service.PayService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private GoodsFeignClient goodsFeignClient;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Override
    @GlobalTransactional(name = "fsp-pay-order", rollbackFor = Exception.class)
    public ReturnData payOrder(String orderNo) {
        //查询订单信息
        ReturnData<OrderVo> returnData = orderFeignClient.getByOrderNo(orderNo);
        if (null == returnData || returnData.getCode() == 0)
            return new ReturnData(0, "查询订单异常，订单号:" + orderNo);
        OrderVo vo = returnData.getData();
        if (vo.getPayAmount() <= 0)
            return new ReturnData(0, "订单金额异常,金额:" + vo.getPayAmount());
        UserVo userVo = new UserVo();
        userVo.setUserId(vo.getUserId());
        userVo.setBalance(vo.getPayAmount());
        ReturnData userDate = userFeignClient.deduct(userVo);
        if (null == userDate)
            throw new BusinessException("支付失败!");
        if (userDate.getCode() == 0)
            throw new BusinessException(userDate.getDesc());
        //扣减库存
        GoodsVo goodsVo = new GoodsVo();
        goodsVo.setCount(vo.getOrderCount());
        goodsVo.setGoodsSkuId(vo.getSkuId());
        ReturnData goodsReturnData =  goodsFeignClient.deductStock(goodsVo);
        if (0 == goodsReturnData.getCode())
            throw new  BusinessException(goodsReturnData.getDesc(),-1);
        //通知订单修改订单状态
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(vo.getOrderNo());
        orderVo.setOrderState(1);
        ReturnData orderReturnData = orderFeignClient.payOrderSuccess(orderVo);
        if (0 == orderReturnData.getCode())
            throw new  BusinessException(orderReturnData.getDesc(),-1);
        return userDate;
    }
}
