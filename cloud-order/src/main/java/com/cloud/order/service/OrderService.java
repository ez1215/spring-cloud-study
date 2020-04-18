package com.cloud.order.service;

import com.cloud.common.vo.OrderVo;
import com.cloud.order.dto.OrderDto;

public interface OrderService {
    public void createOrder(OrderDto dto);

    public OrderVo getByOrderNo(String orderNo);

    public void update(OrderVo vo) throws Exception;

}
