package com.liuxun.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liuxun
 * @create 2023-08-15 16:52
 * @description
 */
@SpringBootApplication
public class redisApplication {
    public static void main(String[] args) {
        SpringApplication.run(redisApplication.class,args);
    }
}
