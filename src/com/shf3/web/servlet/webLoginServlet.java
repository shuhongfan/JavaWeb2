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

@WebServlet(name = "webLoginServlet", value = "/webLoginServlet")
public class webLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.设置编码
        request.setCharacterEncoding("utf-8");
//        2.获取数据
        String verifycode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();
//        3.验证码校验
        HttpSession session = request.getSession();
        Object checkcode_server = session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // 确保验证码一致性
        if(!verifycode.equals(checkcode_server)){
//            验证信息不正确
//            提示信息
            request.setAttribute("login_msg","验证码不正确");
//            跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
//        4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        5.调用service查询
        UserServiceImpl service = new UserServiceImpl();
        User loginUser = service.login(user);
//        6.判读是否登录成功
        if (loginUser!=null){
//            登录成功
//            将用户存入session
            session.setAttribute("user",loginUser);
//            跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
//            登录失败
//            提示信息
            request.setAttribute("login_msg","用户名或密码错误！！！");
//            跳转到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
