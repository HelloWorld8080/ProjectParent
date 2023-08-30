package com.liuxun.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author liuxun
 * @create 2023-07-07 21:53
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.liuxun.order.client")
public class OrderApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(OrderApplication.class, args);
//        run.getBean(OrderService.class).generateOrder(new OrderVo(1L,95));
//        ProductVo productVo = new ProductVo();
//        productVo.setProductId(1L);
//        productVo.setStore(2);
//        run.getBean(Service11Client.class).updateStoreByid(productVo);
//        ((OrderDao)run.getBean("orderDao")).insertOrder(new Order(1L,1L,1L,1.0,0,"bzff"));
//        List<Order> orders= run.getBean(OrderDao.class).findAll();

//        System.out.println("fdf");
//        List<Order> orders = new ArrayList<>();
//
//
//        for (long i = 1; i < 10001; i++) {
//            orders.add(new Order(i,i,i,i*1.0,0,"bz"+i));
//        }
//        long s = new Date().getTime();
//        run.getBean(OrderDao.class).deleteOrder();
//        run.getBean(OrderDao.class).insertBatchOrder(orders);
//        long e = new Date().getTime();
//        run.getBean(OrderDao.class).deleteOrder();
//        orders.stream().forEach(item->run.getBean(OrderDao.class).insertOrder(item));
//        long e1 = new Date().getTime();
//        System.out.println("insertBatchOrder time："+(e-s));
//        System.out.println("insertBatchOrder time："+(e1-e));
    }
}
