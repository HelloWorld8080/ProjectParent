package com.liuxun.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuxun.account.entity.Account;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxun
 * @create 2023-08-15 11:09
 * @description
 */
public interface AccountService extends IService<Account> {

    @GlobalTransactional
    @Transactional
    void pay(String xid,Long orderId,Long accountId, Double payMoney);

}
