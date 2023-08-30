package com.liuxun.order.client.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxun
 * @create 2023-08-14 15:00
 * @description
 */
@Slf4j
public class FeignIntercepter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("***********FeignIntercepter");
        requestTemplate.header("xid", RootContext.getXID());
    }
}
