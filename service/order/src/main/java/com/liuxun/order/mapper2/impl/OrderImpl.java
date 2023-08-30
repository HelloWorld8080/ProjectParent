package com.liuxun.order.mapper2.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.liuxun.order.entity.Order;
import com.liuxun.order.mapper2.OrderDao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-25 23:02
 * @description
 */

@Component
public class OrderImpl implements OrderDao2 {

    @Autowired
    private List<DataSource> myDataSources;

    @Resource
    private DataSource masterDataSource;

    @Autowired
    private DataSource slaveDataSource;

    @Override
    public void insertOrder(Order order) {
        System.out.println(myDataSources);
        System.out.println(masterDataSource);
        System.out.println(slaveDataSource);
        DruidDataSource dataSource = new DruidDataSource();
    }

    @Override
    public void insertBatchOrder(List<Order> orders) {

    }

    @Override
    public void deleteOrder() {

    }
}
