package com.cloud.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_goods_attr")
public class GoodsAttr implements Serializable {
    private static final long serialVersionUID = 7058355913792170789L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("attr_name")
    private String attrName;

    @TableField("sort")
    private Integer sort;
}
