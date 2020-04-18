package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.common.exception.BusinessException;
import com.cloud.common.vo.UserVo;
import com.cloud.user.mapper.UserMapper;
import com.cloud.user.entity.User;
import com.cloud.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = new User();
        user.setName(name);
        queryWrapper.setEntity(user);
        List<User> list = userMapper.selectList(queryWrapper);
        if (null == list || list.isEmpty())
            return null;
        return list.get(0);
    }

    @Override
    public int updateBalance(UserVo vo) throws BusinessException {
        User user = userMapper.selectById(vo.getUserId());
        if (null == user)
            throw new BusinessException("用户不存在!");

        if (user.getBalance() - vo.getBalance() < 0)
            throw new BusinessException("用户余额不足!");

        return userMapper.updateBalance(vo);
    }
}
