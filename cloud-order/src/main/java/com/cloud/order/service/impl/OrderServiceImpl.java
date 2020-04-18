package com.cloud.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.vo.OrderVo;
import com.cloud.order.mapper.OrderMapper;
import com.cloud.order.service.OrderService;
import com.cloud.order.dto.OrderDto;
import com.cloud.order.entity.Order;
import com.cloud.order.feign.GoodsFeignClient;
import com.cloud.order.utils.OrderNoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private GoodsFeignClient goodsFeignClient;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public void createOrder(OrderDto dto) {
        Order order = new Order();
        order.setOrderNo(OrderNoUtils.genOrderNo());
        order.setCouponId(dto.getCouponId());
        order.setGoodsId(dto.getGoodsId());
        order.setOrderCount(dto.getOrderCount());
        order.setOrderState(0);
        order.setSkuId(dto.getSkuId().toString());
        Double amount = this.calcOrderAmount(dto);
        order.setOrderAmount(amount);
        order.setPayAmount(amount);
        order.setUserId(1);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insert(order);
    }

    @Override
    public OrderVo getByOrderNo(String orderNo) {
        Order order = new Order();
        order.setOrderNo(orderNo);
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>(order);
        order = orderMapper.selectOne(queryWrapper);
        if (null == order)
            throw new BusinessException("订单不存在,订单号:" + orderNo, -1);
        OrderVo vo = new OrderVo();
        BeanUtils.copyProperties(order, vo);
        vo.setSkuId(Integer.valueOf(order.getSkuId()));
        return vo;
    }

    @Override
    public void update(OrderVo vo) throws Exception{
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        Order o = new Order();
        o.setOrderNo(vo.getOrderNo());
        queryWrapper.setEntity(o);
        Order order = new Order();
        BeanUtils.copyProperties(vo, order);
        order.setOrderNo(null);
        orderMapper.update(order, queryWrapper);
        o = null;
        order = null;
        vo = null;
    }

    private Double calcOrderAmount(OrderDto dto) {
        if (null == dto)
            throw new BusinessException("金额不能为空", -1);
        if (null == dto.getSkuId())
            throw new BusinessException("商品不能为空", -1);
        Double skuPrice = goodsFeignClient.getGoodsPrice(dto.getSkuId());

        BigDecimal couponAmount = new BigDecimal(100);
        BigDecimal amount = new BigDecimal(skuPrice).multiply(new BigDecimal(dto.getOrderCount())).subtract(couponAmount);
        return amount.doubleValue();
    }
}
