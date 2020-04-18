package com.cloud.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("t_order")
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -2134798357082419260L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("order_no")
    private String orderNo;

    @TableField("order_state")
    private Integer orderState;

    @TableField("order_amount")
    private Double orderAmount;

    @TableField("pay_amount")
    private Double payAmount;

    @TableField("pay_time")
    private Date payTime;

    @TableField("order_count")
    private Integer orderCount;

    @TableField("coupon_id")
    private String couponId;

    @TableField("goods_id")
    private String goodsId;

    @TableField("sku_id")
    private String skuId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
