package com.liuxun.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuxun.user.entity.User;

/**
 * @author liuxun
 * @create 2023-08-18 16:52
 * @description
 */
public interface UserService extends IService<User> {

    Long getUserIdByPhone(String phone);
}
