package com.shf3.web.servlet;

import com.shf3.domain.PageBean;
import com.shf3.domain.User;
import com.shf3.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "findUserByPageServlet", value = "/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        1.获取参数
//        当前页码
        String currentPage = request.getParameter("currentPage");
//        每页显示的条数
        String rows = request.getParameter("rows");
//        设置默认值
        if (currentPage == null || "".equals(currentPage)) currentPage="1";
        if (rows == null || "".equals(rows)) rows="5";

//        获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
//        2.调用service
        UserServiceImpl userService = new UserServiceImpl();
        PageBean<User> pb = userService.findUserByPage(currentPage,rows,condition);
//        3.将pageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
//        4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
