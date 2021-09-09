package com.shf.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo02 implements Servlet {
//    生命周期
//    初始化方法  在servlet被创建时执行,只会执行一次
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

//    获取servletConfig对象  servlet配置对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

//    提供服务的方法 每一次servlet被访问时执行,执行多次
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service");
    }

//    获取servlet的一些信息 版本 作者等等 一般部署hi有
    @Override
    public String getServletInfo() {
        return null;
    }

//    销毁方法 在服务器正常关闭时执行,只执行一次
    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
