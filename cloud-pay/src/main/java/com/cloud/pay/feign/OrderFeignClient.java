package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cloud-order", fallbackFactory = OrderFeignClientFallbackFactory.class)
public interface OrderFeignClient {

    @RequestMapping("/order/payOrderSuccess/")
    public ReturnData payOrderSuccess(@RequestBody OrderVo orderVo);

    @PostMapping("/order/getByOrderNo/")
    public ReturnData<OrderVo> getByOrderNo(@RequestBody String orderNo);
}
