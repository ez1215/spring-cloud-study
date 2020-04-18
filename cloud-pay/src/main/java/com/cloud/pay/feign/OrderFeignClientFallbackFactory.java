package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.OrderVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderFeignClientFallbackFactory implements FallbackFactory<OrderFeignClient> {
    @Override
    public OrderFeignClient create(Throwable throwable) {
        log.info("用户接口调用失败,{}", throwable.getMessage());
        return new OrderFeignClient() {
            @Override
            public ReturnData payOrderSuccess(OrderVo orderVo) {
                return new ReturnData(-1, "订单支付失败," + throwable.getMessage());
            }

            @Override
            public ReturnData getByOrderNo(String orderNo) {
                return new ReturnData(-1, "查询订单失败," + throwable.getMessage());
            }
        };
    }
}
