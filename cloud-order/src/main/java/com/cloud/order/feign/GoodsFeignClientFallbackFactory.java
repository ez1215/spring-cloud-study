package com.cloud.order.feign;

import com.cloud.common.exception.BusinessException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GoodsFeignClientFallbackFactory implements FallbackFactory<GoodsFeignClient> {
    @Override
    public GoodsFeignClient create(Throwable throwable) {
        log.info("订单调用商品feign接口失败>> {}",throwable.getMessage());
        return new GoodsFeignClient() {
            @Override
            public Double getGoodsPrice(Integer skuId) {
                throw new BusinessException("获取商品价格异常",-1);
            }
        };
    }
}
