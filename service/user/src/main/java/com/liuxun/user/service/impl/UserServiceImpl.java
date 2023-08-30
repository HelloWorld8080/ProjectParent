package com.liuxun.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuxun.user.mapper.UserMapper;
import com.liuxun.user.entity.User;
import com.liuxun.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author liuxun
 * @create 2023-08-18 16:53
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public Long getUserIdByPhone(String phone) {
        return this.getBaseMapper().selectOne(new QueryWrapper<User>().eq("phone",phone)).getUserId();
    }
}
