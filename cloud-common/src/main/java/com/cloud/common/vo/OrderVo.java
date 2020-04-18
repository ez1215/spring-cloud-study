package com.cloud.common.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderVo implements Serializable {

    private static final long serialVersionUID = -9186669232458960959L;

    private String orderNo;

    private Double payAmount;

    private Integer userId;

    private Integer orderCount;

    private Integer skuId;

    private Integer orderState;
}
