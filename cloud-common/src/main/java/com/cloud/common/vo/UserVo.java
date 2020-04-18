package com.cloud.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = 3412589963547293400L;

    private Integer userId;

    private Double balance;
}
