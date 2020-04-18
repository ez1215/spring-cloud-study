package com.cloud.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_goods_attr_val")
public class GoodsAttrVal implements Serializable {
    private static final long serialVersionUID = -4818532633923691538L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("attr_id")
    private Integer attrId;

    @TableField(exist = false)
    private transient String attrName;

    @TableField("attr_val")
    private String attrVal;
}
