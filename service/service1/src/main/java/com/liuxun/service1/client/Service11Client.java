package com.liuxun.service1.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author liuxun
 * @create 2023-07-12 23:17
 * @description
 */
@FeignClient("com/liuxun/service1")
public interface Service11Client {

}
