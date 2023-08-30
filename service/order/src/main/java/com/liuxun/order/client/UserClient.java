package com.liuxun.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxun
 * @create 2023-08-18 16:33
 * @description
 */

@FeignClient("user")
@RequestMapping("/user")
public interface UserClient {

    @GetMapping("/getUserIdByPhone/{phone}")
    Long getUserIdByPhone(@PathVariable("phone") String phone);
}
