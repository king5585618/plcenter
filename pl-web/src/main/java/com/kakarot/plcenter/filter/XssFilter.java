//package com.kakarot.plcenter.filter;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.Set;
//
///**
// * Created by jinzj on 2017/3/8.
// */
//@Deprecated
//public class XssFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        if ("application/json".equals(request.getContentType())) {
//            StringBuilder sb = new StringBuilder();
//            try {
//                BufferedReader reader = request.getReader();
//                char[] buff = new char[1024];
//                int len;
//                while ((len = reader.read(buff)) != -1) {
//
//                    sb.append(buff, 0, len);
//                }
//            } catch (IOException e) {
//
//            }
//            JSONObject object = JSON.parseObject(sb.toString());
//            Set<String> set = object.keySet();
//            for (String s : set) {
//                request.setAttribute(s, object.get(s));
//            }
//        }
//        chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
