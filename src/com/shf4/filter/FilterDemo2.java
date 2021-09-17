package com.shf4.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.FORWAR,DispatcherType.REQUEST})
public class FilterDemo2 implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("index.jsp");
        chain.doFilter(request, response);
    }
}
