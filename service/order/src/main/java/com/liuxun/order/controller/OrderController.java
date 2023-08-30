package com.liuxun.order.controller;

import com.liuxun.model.order.OrderVo;
import com.liuxun.order.service.OrderService;
import com.liuxun.order.service.RbdaService;
import com.liuxun.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author liuxun
 * @create 2023-07-12 20:05
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Resource
//    private RbdaService rbdaService;

    @PostMapping("/generateOrder")
    Result generateOrder(HttpServletRequest request,@RequestBody OrderVo vo){
        //获取用户表名
        String phone = (String)request.getAttribute("phone");
        vo.setPhone(phone);

//        rbdaService.getOneByPhone(phone);
        return Result.ok(orderService.generateOrder(vo));
    }
    @GetMapping("/test")
    Result test(){
        return Result.ok();
    }
}
