package com.liuxun.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuxun.account.entity.Account;
import com.liuxun.account.mapper.AccountMapper;
import com.liuxun.account.service.AccountService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liuxun
 * @create 2023-08-15 11:19
 * @description
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private RedisTemplate<String,String> redisTemplate;
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void pay(String xid,Long orderId,Long accountId, Double payMoney) {
        String paystatus = redisTemplate.opsForValue().get(orderId.toString());
        if("0".equals(paystatus)){
            redisTemplate.opsForValue().set(orderId.toString(),"0",1, TimeUnit.DAYS);
            Account account = new Account();
            account.setAccountId(accountId);
            QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
            accountQueryWrapper.eq("account_id",accountId);
            account.setMoney(accountMapper.selectOne(accountQueryWrapper).getMoney()-payMoney);
            accountMapper.updateById(account);
            redisTemplate.opsForValue().set(orderId.toString(),"1");
            redisTemplate.convertAndSend(orderId.toString(),"2");
        }
    }
}
