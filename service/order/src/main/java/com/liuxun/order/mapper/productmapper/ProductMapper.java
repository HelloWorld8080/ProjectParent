package com.liuxun.order.mapper.productmapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author liuxun
 * @create 2023-08-11 11:02
 * @description
 */
public interface ProductMapper {

    void updateStoreByProductId(@Param("productId") Long productId,@Param("value") Integer value);

    Integer getStoreByProductId(Long productId);
}
