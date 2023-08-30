package com.liuxun.order.mapper.rbdamapper;

import com.liuxun.order.entity.Rbda;

/**
 * @author liuxun
 * @create 2023-08-08 20:27
 * @description
 */
//@DS("rbda")
public interface RbdaMapper {
    Rbda getOneByPhone(String phone);

    void insert(Rbda rbda);

}
