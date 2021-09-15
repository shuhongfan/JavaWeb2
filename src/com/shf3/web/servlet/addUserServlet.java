package com.shf3.web.servlet;

import com.shf3.domain.User;
import com.shf3.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "addUserServlet", value = "/addUserServlet")
public class addUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.设置编码
        request.setCharacterEncoding("utf-8");
//        2.获取参数
        Map<String, String[]> map = request.getParameterMap();
//        3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        4.调用service保存
        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user);
//        5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
