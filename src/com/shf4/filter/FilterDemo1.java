package com.shf4.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
//        加载资源
        System.out.println("init....");
    }

    public void destroy() {
//        释放资源
        System.out.println("destroy...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
//        对request对象请求消息增强
        System.out.println("FilterDemo1执行了");
//        放行
        chain.doFilter(request, response);

//        对response的相应消息增强
        System.out.println("FilterDemo1回来了");
    }
}
