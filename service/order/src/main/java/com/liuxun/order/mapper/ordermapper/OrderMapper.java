package com.liuxun.order.mapper.ordermapper;

import com.liuxun.order.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-07 20:12
 * @description
 */

//@DS("master")
public interface OrderMapper{

//    @DS("master")
    void insertOrder(Order order);

    @Select("select * from `order`")
    List<Order> findAll();

    void insertBatchOrder(List<Order> orders);

    void deleteOrder();
    List<Order> getOrdersByPage(Integer page,Integer limit);

    void updatePayStatusByOrderId();

    void updatePayStatusByOrderId(@Param("orderId") Long orderId,@Param("payStatus")  Integer payStatus);
}
