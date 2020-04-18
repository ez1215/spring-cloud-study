package com.cloud.pay.feign;

import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.UserVo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        log.info("用户接口调用失败,{}", throwable.getMessage());
        return new UserFeignClient() {
            @Override
            public ReturnData deduct(UserVo userVo) {
                return new ReturnData(-1, "支付失败," + throwable.getMessage());
            }
        };
    }
}
