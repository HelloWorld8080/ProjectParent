package com.liuxun.order.config;

import com.liuxun.order.intercepter.UrlIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuxun
 * @create 2023-08-08 20:43
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(urlIntercepter()).addPathPatterns("/order/generateOrder");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    @Bean
    public UrlIntercepter urlIntercepter(){
        return new UrlIntercepter();
    }
}
