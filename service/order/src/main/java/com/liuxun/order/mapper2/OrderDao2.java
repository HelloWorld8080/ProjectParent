package com.liuxun.order.mapper2;

import com.liuxun.order.entity.Order;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-07 20:12
 * @description
 */

//@Mapper
public interface OrderDao2 {


    void insertOrder(Order order);


//    @Select("select * from `order`")
//    List<Order> findAll();

    void insertBatchOrder(List<Order> orders);

    void deleteOrder();
}
