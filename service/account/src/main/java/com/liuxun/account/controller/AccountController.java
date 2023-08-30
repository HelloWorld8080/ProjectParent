package com.liuxun.account.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuxun.account.entity.Account;
import com.liuxun.account.service.AccountService;
import com.liuxun.util.result.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author liuxun
 * @create 2023-08-15 11:03
 * @description
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountSevice;
    @Resource
    private RedisTemplate redisTemplate;

    @PutMapping("/pay/{orderId}/{accountId}/{payMoney}")
    public Result pay(@PathVariable("orderId") Long orderId, @PathVariable("accountId") Long accountId,@PathVariable("payMoney") Double payMoney){
        String xid = (String)redisTemplate.opsForValue().get(orderId.toString()+":xid");
        accountSevice.pay(xid,orderId,accountId,payMoney);
        return Result.ok();
    }
}
