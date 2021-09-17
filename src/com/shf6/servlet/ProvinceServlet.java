package com.shf6.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shf6.dao.impl.ProvinceDaoImpl;
import com.shf6.domain.Province;
import com.shf6.service.ProvinceService;
import com.shf6.service.impl.ProvinceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProvinceServlet", value = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.调用service查询
//        ProvinceServiceImpl service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();

//        2.序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
//        System.out.println(json);

//        1.调用service查询
        ProvinceServiceImpl service = new ProvinceServiceImpl();
        String json = service.findAllJson();
//        3.相应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
