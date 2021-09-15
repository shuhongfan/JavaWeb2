package com.shf1.servlet;

import com.shf.domain.User;
import com.shf.domain.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "loginSer", value = "/loginSer")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.设置request编码
        request.setCharacterEncoding("utf-8");
//        2.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode").toLowerCase(Locale.ROOT);
//        3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_Session");
//        删除session中存储的验证码
        session.removeAttribute("checkCode_Session");
        if (checkCode_session!=null && checkCode_session.toLowerCase(Locale.ROOT).equals(checkCode)){
//            验证码正确
//            判断用户名或密码时候一致
//            封装user对象
//            创建user对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
//            调用userDAo的login方法
            UserDao userDao = new UserDao();
            User login = userDao.login(user);
            if (login!=null){
//                登录成功
//                存储用户信息
                session.setAttribute("user",username);
//                重定向到success.jsp
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            } else {
//                登录失败
//                存储提示信息到request
                request.setAttribute("login_error","用户名或密码错误");
//                转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        } else {
//            验证码不一致
//            存储提示信息到request
            request.setAttribute("cc_error","验证码错误");
//            转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
