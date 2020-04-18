package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cloud-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @PostMapping("/user/deduct")
    public ReturnData deduct(@RequestBody UserVo userVo);
}
