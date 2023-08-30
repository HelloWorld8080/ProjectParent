package com.liuxun.product.mapper;

import com.liuxun.model.product.ProductVo;
import com.liuxun.product.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuxun
 * @create 2023-07-19 23:27
 * @description
 */
public interface ProductDao {
    void updateStoreByid(@Param("store") Integer store,@Param("productId") Long id);

    List<Product> findAll();

    void updateStoresByid(List<ProductVo> ps);

    Integer getStore(@Param("productId") Long  productId);
    Double getPrice(@Param("productId") Long  productId);

    void updateStoreByProductId(@Param("productId") Long productId, @Param("store") Integer store);

    List<Product> batchGetStore(List<ProductVo> productVos);

    void batchUpdateStoreByProductId(List<ProductVo> productVos);
}
