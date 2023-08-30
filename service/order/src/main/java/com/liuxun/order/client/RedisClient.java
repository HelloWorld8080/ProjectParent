package com.liuxun.order.client;

import com.liuxun.util.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxun
 * @create 2023-08-15 17:03
 * @description
 */
@FeignClient("redis")
@RequestMapping("/redis")
public interface RedisClient {
    @PutMapping("/updatePayStatusByOrderId/{xid}/{orderId}/{payStatus}")
    Result updatePayStatusByOrderId(@PathVariable("xid") String xid,@PathVariable("orderId") Long orderId, @PathVariable("payStatus") Integer payStatus);
}
