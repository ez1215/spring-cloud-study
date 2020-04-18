package com.cloud.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 3263059286203821316L;
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableField("last_login_time")
    private Date lastLoginTime;

    @TableField("balance")
    private Double balance;
}
