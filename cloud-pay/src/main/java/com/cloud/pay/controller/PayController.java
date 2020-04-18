package com.cloud.pay.controller;

import com.cloud.common.controller.BaseController;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.OrderVo;
import com.cloud.pay.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController extends BaseController {

    @Autowired
    private PayService payService;

    @PostMapping("/payOrder")
    public ReturnData payOrder(@RequestBody OrderVo vo) {
        try {
            log.info("订单支付···,单号:{}", vo.toString());
            if (StringUtils.isBlank(vo.getOrderNo()))
                return initErrorObjectResult("订单号不能为空");
            return payService.payOrder(vo.getOrderNo());
        } catch (BusinessException e) {
            return initErrorObjectResult(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return initErrorResult();
        }
    }
}
