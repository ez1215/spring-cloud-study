package com.cloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-goods", fallbackFactory = GoodsFeignClientFallbackFactory.class)
public interface GoodsFeignClient {

    @PostMapping("/goods/getGoodsPrice")
    public Double getGoodsPrice(@RequestBody Integer skuId);
}
