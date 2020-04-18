package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.GoodsVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GoodsFeignClientFallbackFactory implements FallbackFactory<GoodsFeignClient> {
    @Override
    public GoodsFeignClient create(Throwable throwable) {
        log.info("用户接口调用失败,{}", throwable.getMessage());
        return new GoodsFeignClient() {
            @Override
            public ReturnData deductStock(GoodsVo goodsVo) {
                return new ReturnData(-1, "订单支付失败," + throwable.getMessage());
            }
        };
    }
}
