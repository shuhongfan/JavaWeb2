package com.shf5.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ajaxServlet", value = "/ajaxServlet")
public class ajaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取请求参数
        String username = request.getParameter("username");
//        2.打印username
        System.out.println(username);
//        3.相应
        response.getWriter().write("hello:"+username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
