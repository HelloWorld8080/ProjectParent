package com.liuxun.order.client;

import com.liuxun.model.product.ProductVo;
import com.liuxun.util.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-08-15 10:17
 * @description
 */
@FeignClient("account")
@RequestMapping("/account")
public interface AccountClient {

    @PutMapping("/pay/{xid}/{accountId}/{payMoney}")
    Result pay(@PathVariable("xid") String xid, @PathVariable("accountId") Long accountId,@PathVariable("payMoney") Double payMoney);

}
