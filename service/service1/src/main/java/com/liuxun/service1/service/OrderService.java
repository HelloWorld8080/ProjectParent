package com.liuxun.service1.service;

import com.liuxun.model.service1.OrderVo;
import com.liuxun.model.service11.ProductVo;
//import com.liuxun.service1.client.Service11Client;
import com.liuxun.service1.entity.Order;
import com.liuxun.service1.mapper.OrderDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxun
 * @create 2023-07-08 1:51
 * @description
 */
@Service
public class OrderService {
    @Autowired
    public OrderDao orderDao;
//    @Autowired
//    public Service11Client service11Client;

//    public void insert(Order or){
//        orderDao.insertOrder(or);
//    }
//    public void generateOrder(OrderVo v){
//        ProductVo productVo = new ProductVo();
//        BeanUtils.copyProperties(v,productVo);
////        service11Client.updateStoreByid(productVo);
//    }
}
