package com.liuxun.service11.controller;

import com.liuxun.model.service11.ProductVo;
import com.liuxun.service11.entity.Product;
import com.liuxun.service11.service.Service11Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:24
 * @description
 */
@RestController
@RequestMapping("/service11")
public class Service11Controller {
    @Autowired
    private Service11Service service11Service;

    @PostMapping(value = "/updateStoreByid")
    Boolean updateStoreByid(@RequestBody ProductVo v){
        return service11Service.updateStoreById(v);
    }
    @GetMapping("/findAll")
    List<Product> findAll(ProductVo v){
        return service11Service.findAll();
    }
}
