package com.shf3.web.servlet;

import com.shf3.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delSelectServlet", value = "/delSelectServlet")
public class delSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取所有的id
        String[] uids = request.getParameterValues("uid");
//        2.调用service删除
        UserServiceImpl userService = new UserServiceImpl();
        userService.delSelectedUser(uids);
//        3.跳转查询所有servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
