package com.liuxun.product.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;

/**
 * @author liuxun
 * @create 2023-08-14 17:15
 * @description
 */
public class ProductIntercepter implements RequestInterceptor {
    public void apply(RequestTemplate var1){

        RootContext.bind(String.valueOf(var1.headers().get("xid")));
    }
}
