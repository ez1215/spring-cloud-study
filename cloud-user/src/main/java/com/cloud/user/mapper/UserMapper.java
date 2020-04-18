package com.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.vo.UserVo;
import com.cloud.user.entity.User;

public interface UserMapper extends BaseMapper<User> {
    public int updateBalance(UserVo vo);
}
