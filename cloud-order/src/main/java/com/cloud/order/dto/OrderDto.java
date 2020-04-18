package com.cloud.order.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDto implements Serializable {
    private static final long serialVersionUID = -7311601106071861999L;

    private String goodsId;

    private Integer skuId;

    private String couponId;

    private Double orderAmount;

    private Double PayAmount;

    private Integer orderCount;
}
