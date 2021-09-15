package com.shf3.web.servlet;

import com.shf3.domain.User;
import com.shf3.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "findUserServlet", value = "/findUserServlet")
public class findUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取id
        String id = request.getParameter("id");
//        2.调用service查询
        UserServiceImpl service = new UserServiceImpl();
        User user=service.findUserById(id);
//        3.将user存入request
        request.setAttribute("user",user);
//        4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
