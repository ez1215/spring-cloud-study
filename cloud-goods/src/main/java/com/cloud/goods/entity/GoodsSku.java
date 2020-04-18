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
@TableName("t_goods_sku")
public class GoodsSku implements Serializable {
    private static final long serialVersionUID = -1978000476429650896L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("goods_id")
    private Integer goodsId;

    @TableField("stock")
    private Integer stock;

    @TableField("image")
    private String image;

    @TableField("title")
    private String title;

    @TableField("price")
    private Double price;

    @TableField("attr_id")
    private String attrId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField(exist = false)
    private transient List<GoodsAttrVal> goodsAttrValList;

}
