package com.liuxun.service1.client;

import com.liuxun.model.service11.ProductVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liuxun
 * @create 2023-07-12 23:17
 * @description
 */
@RequestMapping("/service11")
@FeignClient("service11")
public interface Service11Client {
    @PostMapping(value="/updateStoreByid")
    Boolean updateStoreByid(ProductVo v);
}
