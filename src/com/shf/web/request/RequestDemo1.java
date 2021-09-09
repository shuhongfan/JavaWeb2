package com.shf.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求方式
        String method = req.getMethod();
        System.out.println(method);

//        获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

//        获取servlet路径
        String servletPath = req.getServletPath();
        System.out.println(servletPath);

//        获取get方式请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

//        获取uri
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

//        获取url
        StringBuffer requestURL = req. getRequestURL();
        System.out.println(requestURL);

//        获取远端地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
