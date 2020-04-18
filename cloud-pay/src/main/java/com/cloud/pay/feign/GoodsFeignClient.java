package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.GoodsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-goods", fallbackFactory = GoodsFeignClientFallbackFactory.class)
public interface GoodsFeignClient {

    @PostMapping("goods/deductStock")
    public ReturnData deductStock(@RequestBody GoodsVo goodsVo);
}
