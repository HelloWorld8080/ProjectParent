package com.liuxun.user.controller;

import com.liuxun.user.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuxun
 * @create 2023-08-18 16:48
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @GetMapping("/getUserIdByPhone/{phone}")
    Long getUserIdByPhone(@PathVariable("phone") String phone){
        return userService.getUserIdByPhone(phone);
    }
}
