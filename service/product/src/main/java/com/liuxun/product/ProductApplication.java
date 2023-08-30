package com.liuxun.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author liuxun
 * @create 2023-07-15 15:00
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.liuxun.product.mapper")
@EnableFeignClients("com.liuxun.product")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
