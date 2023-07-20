package com.liuxun.service11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liuxun
 * @create 2023-07-15 15:00
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.liuxun.service11.mapper")
public class Service11Application {
    public static void main(String[] args) {
        SpringApplication.run(Service11Application.class, args);
    }
}
