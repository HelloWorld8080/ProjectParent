package com.liuxun.service1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxun
 * @create 2023-07-07 23:26
 * @description
 */
@Configuration
@MapperScan("com.liuxun.service1.mapper")
public class OrderConfig {
}
