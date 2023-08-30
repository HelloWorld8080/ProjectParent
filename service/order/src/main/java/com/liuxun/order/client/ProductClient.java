package com.liuxun.order.client;

import com.liuxun.model.product.ProductVo;
import com.liuxun.util.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-12 23:17
 * @description
 */

@FeignClient("product")
@RequestMapping("/product")
public interface ProductClient {
    @PostMapping(value="/updateStoreByid",consumes = "application/json")
    Result updateStoreByid(List<ProductVo> ps);

    @PostMapping(value="/updateStoresByid")
    Result updateStoresByid(List<ProductVo> ps);

    @GetMapping(value = "/getStore/{productId}")
    Integer getStore(@PathVariable("productId") Long productId);

    @GetMapping(value = "/getPrice/{productId}")
    Double getPrice(@PathVariable("productId") Long productId);

    @PutMapping(value="/updateStoreByProductId/{xid}/{productId}/{store}")
    Result updateStoreByProductId(@PathVariable("xid") String xid,@PathVariable("productId") Long productId,@PathVariable("store") Integer store);

    @PutMapping(value="/batchUpdateStoreByProductId/{xid}")
    Result batchUpdateStoreByProductId(@PathVariable("xid") String xid, @RequestBody List<ProductVo> productVos);
}
