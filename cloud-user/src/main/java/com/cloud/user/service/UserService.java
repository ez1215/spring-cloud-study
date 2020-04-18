package com.cloud.user.service;

import com.cloud.common.exception.BusinessException;
import com.cloud.common.vo.UserVo;
import com.cloud.user.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getById(Integer id);

    User getByName(String name);

    int updateBalance(UserVo vo) throws BusinessException;
}
