package com.liuxun.service11.service;

import com.liuxun.model.service11.ProductVo;
import com.liuxun.service11.entity.Product;
import com.liuxun.service11.mapper.Service11Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:26
 * @description
 */
@Service
public class Service11Service {
    @Autowired
    private Service11Dao service11Dao;

    public  Boolean updateStoreById(ProductVo v){

        try {
            service11Dao.updateStoreByid(v);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<Product> findAll(){
        return service11Dao.findAll();
    }
}
