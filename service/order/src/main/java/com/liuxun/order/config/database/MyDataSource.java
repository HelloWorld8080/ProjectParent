package com.liuxun.order.config.database;

import java.lang.annotation.*;

/**
 * @author liuxun
 * @create 2023-07-24 0:50
 * @description
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyDataSource {
    String value();
}
