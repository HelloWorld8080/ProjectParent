package com.liuxun.redis;

import com.liuxun.util.result.Result;
import io.seata.core.context.RootContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuxun
 * @create 2023-08-15 16:56
 * @description
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisTemplate redisTemplate;

    @PutMapping("/updatePayStatusByOrderId/{xid}/{orderId}/{payStatus}")
    public Result updatePayStatusByOrderId(@PathVariable("xid") String xid,@PathVariable("orderId") Long orderId, @PathVariable("payStatus") Integer payStatus){
        RootContext.bind(xid);
        redisTemplate.opsForValue().set(orderId.toString(),payStatus.toString());
        return Result.ok();
    }
}
