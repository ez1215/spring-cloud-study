package com.cloud.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsVo implements Serializable {
    private static final long serialVersionUID = 1027011215874846214L;

    private Integer goodsSkuId;

    private Integer count;
}
