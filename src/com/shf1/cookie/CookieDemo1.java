package com.shf1.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo1", value = "/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.创建cookie对象
        Cookie cookie = new Cookie("msg", "hello");
//        设置cookie的存活时间
        cookie.setMaxAge(20);

//        不同服务器之间cookie共享
//        cookie.setDomain(".baidu.com");
//        同一个服务器数据共享
//        cookie.setPath("/");

//        2.发送Cookie
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
