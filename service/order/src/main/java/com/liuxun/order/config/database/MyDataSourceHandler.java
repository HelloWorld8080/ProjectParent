package com.liuxun.order.config.database;

import org.mybatis.spring.SqlSessionFactoryBean;

import javax.annotation.Resource;

/**
 * @author liuxun
 * @create 2023-08-09 10:27
 * @description
 */
public class MyDataSourceHandler {
    @Resource
    private SqlSessionFactoryBean sqlSessionFactoryBean;
    public void switchDataSourceHandler(){

//        sqlSessionFactoryBean
    }
}
