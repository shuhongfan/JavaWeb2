package com.shf.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo8被访问了");
//        request代表一次请求域的访问，一般用户请求转发多个资源中共享的数据
//        存储数据到request域中
        req.setAttribute("msg" ,"hello");

//        转发到demo9 浏览器地址栏不发生变化；只能发送到当前服务器中
        req.getRequestDispatcher("/requestDemo9").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
