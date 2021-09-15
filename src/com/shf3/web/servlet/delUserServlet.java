package com.shf3.web.servlet;

import com.shf3.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delUserServlet", value = "/delUserServlet")
public class delUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取id
        String id = request.getParameter("id");
//        2.调用service删除
        UserServiceImpl service = new UserServiceImpl();
        service.deleteUser(id);
//        3.跳转到查询所有servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
