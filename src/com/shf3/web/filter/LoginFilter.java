package com.shf3.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        0.强制转换
        HttpServletRequest req = (HttpServletRequest) request;
//        1.获取资源请求路径
        String uri = req.getRequestURI();
//        2.判断时候包含登录相关资源路径 css,js文件也要排除
        if (uri.contains("/login.jsp")||uri.contains("/webLoginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCode")){
//            包含，用户登录
            chain.doFilter(request, response);
        } else{
//            不包含 需要验证用户是否登录
            Object user = req.getSession().getAttribute("user");
            if (user != null){
//                已经登录
                chain.doFilter(request, response);
            } else {
//                未登录
                req.setAttribute("login_msg","您尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req,response);
            }
        }
    }
}
