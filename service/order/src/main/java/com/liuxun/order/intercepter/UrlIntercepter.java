package com.liuxun.order.intercepter;

import com.liuxun.util.helper.JwtHelper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuxun
 * @create 2023-08-08 17:14
 * @description
 */
public class UrlIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("TOKEN");
        String phone = JwtHelper.getPhone(token);
        request.setAttribute("phone",phone);
        return true;
    }
}
