package com.kakarot.plcenter.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jinzj on 2017/3/8.
 */
public class XssHttpServletRequestFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(new XssHttpServletRequestWrapper(request), response, handler);
    }
}