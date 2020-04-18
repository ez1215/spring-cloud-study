package com.cloud.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("t_goods")
public class Goods implements Serializable {
    private static final long serialVersionUID = -3560203321266759364L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goods_name")
    private String goodsName;

    @TableField("goods_img")
    private String goodsImg;

    @TableField("stock")
    private Integer stock;

    @TableField("sale_count")
    private Integer saleCount;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField(exist = false)
    private transient List<GoodsSku> goodsSkuList;
}
