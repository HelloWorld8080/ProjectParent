package com.liuxun.product.controller;

import com.liuxun.model.product.ProductVo;
import com.liuxun.product.entity.Product;
import com.liuxun.product.service.ProductService;
import com.liuxun.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:24
 * @description
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/updateStoreByid")
    Result updateStoreByid(@RequestBody List<ProductVo> v){
        return productService.updateStoreById(v);
    }

    @GetMapping("/findAll")
    List<Product> findAll(ProductVo v){//针对form-data
        return productService.findAll();
    }

    @PostMapping(value="/updateStoresByid")
    Result updateStoresByid(@RequestBody List<ProductVo> ps){
        return productService.updateStoresById(ps);
    }
    @GetMapping(value = "/getStore/{productId}")
    Integer getStore(@PathVariable("productId") Long productId){
        return productService.getStore(productId);
    }

    @GetMapping(value = "/getPrice/{productId}")
    Double getPrice(@PathVariable("productId") Long productId){
        return productService.getPrice(productId);
    }

    @PutMapping(value="/updateStoreByProductId/{xid}/{productId}/{store}")
    Result updateStoreByProductId(@RequestHeader("xid") String xx, @PathVariable("xid") String xid, @PathVariable("productId") Long productId, @PathVariable("store") Integer store){

//        String xi = (String)httpSession.getAttribute("xid");
        return productService.updateStoreByProductId(xid,productId,store);
    }

    @PutMapping(value="/batchUpdateStoreByProductId/{xid}")
    Result batchUpdateStoreByProductId(@PathVariable("xid") String xid,@RequestBody List<ProductVo> productVos){
        return productService.batchUpdateStoreByProductId(xid, productVos);
    }
}
