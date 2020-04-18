package com.cloud.order.controller;

import com.cloud.common.controller.BaseController;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.model.ReturnData;
import com.cloud.common.vo.OrderVo;
import com.cloud.order.dto.OrderDto;
import com.cloud.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/getByOrderNo")
    public ReturnData getByOrderNo(String orderNo) {
        try {
            OrderVo vo = orderService.getByOrderNo(orderNo);
            return initSuccessObjectResult(vo);
        } catch (Exception e) {
            return initErrorObjectResult(e.getMessage());
        }
    }


    @RequestMapping("/payOrderSuccess")
    public ReturnData payOrderSuccess(@RequestBody OrderVo orderVo) {
        try {
            orderService.update(orderVo);
            return initSuccessResult();
        } catch (BusinessException be) {
            log.error(be.getMessage(), be);
            return initErrorObjectResult(be.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return initErrorResult();
        }
    }


    @PostMapping("/submitOrder")
    public ReturnData submitOrder(@RequestBody OrderDto dto) {
        try {
            orderService.createOrder(dto);
            return initSuccessResult();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            return initErrorObjectResult(e.getMessage());
        }
    }
}
