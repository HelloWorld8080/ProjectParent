package com.liuxun.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuxun.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuxun
 * @create 2023-08-18 16:59
 * @description
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
