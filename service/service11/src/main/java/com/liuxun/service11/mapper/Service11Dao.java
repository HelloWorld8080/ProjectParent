package com.liuxun.service11.mapper;

import com.liuxun.model.service11.ProductVo;
import com.liuxun.service11.entity.Product;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:27
 * @description
 */
public interface Service11Dao {
    void updateStoreByid(ProductVo v);

    List<Product> findAll();
}
