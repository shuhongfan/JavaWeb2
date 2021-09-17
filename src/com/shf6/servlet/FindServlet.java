package com.shf6.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "FindServlet", value = "/FindServlet")
public class FindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
//        1.获取用户名
        String username = request.getParameter("username");
//        2.调用service层判断用户名是否存在
        HashMap<String, Object> map = new HashMap<>();
        if ("tom".equals(username)){
//            存在
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请更换一个");
        } else {
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
//        将map转换为JSON
        ObjectMapper mapper = new ObjectMapper();
//        传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
