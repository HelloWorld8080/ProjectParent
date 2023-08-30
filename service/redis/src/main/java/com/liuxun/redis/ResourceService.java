package com.liuxun.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author liuxun
 * @create 2023-08-06 16:59
 * @description
 */
public class ResourceService {
    @Resource
    private RedisTemplate<String,String> redisTemplate;
}
