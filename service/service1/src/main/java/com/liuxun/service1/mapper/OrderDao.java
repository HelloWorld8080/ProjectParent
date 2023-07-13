package com.liuxun.service1.mapper;

import com.liuxun.service1.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-07 20:12
 * @description
 */

public interface OrderDao{
    void insertOrder(Order order);

    @Select("select * from `order`")
    List<Order> findAll();

    void insertBatchOrder(List<Order> orders);

    void deleteOrder();
}
