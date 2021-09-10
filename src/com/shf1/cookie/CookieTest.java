package com.shf1.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieTest", value = "/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 遍历所有Cookie
        Cookie[] cookies = request.getCookies();
        boolean flag=false;
//        2. 遍历cookie数组
        if (cookies!=null && cookies.length>0)
            for (Cookie cookie:cookies){
//                3.获取cookie的名称
                String name = cookie.getName();
//                4. 判断名称是否是：lastTime
                if ("lastTime".equals(name)) {
//                    有该cookie，不是第一次访问
                    flag=true;
//                    设置cookie的value
//                    获取当前的时间字符串 重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
//                    url编码
                    str_date=URLEncoder.encode(str_date,"utf-8");
                    cookie.setValue(str_date);
                    response.addCookie(cookie);
//                    设置cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);  //一个月

//                    响应数据  获取cookie的value时间
                    String value = cookie.getValue();
//                    url解码
                    value=URLDecoder.decode(value,"utf-8");

                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间为："+value+"</h1>");
                    break;
                }
            }
        if (cookies==null || cookies.length==0 || flag==false){
//            没有，第一次访问
//                    设置cookie的value
//                    获取当前的时间字符串 重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
//                    url编码
            str_date=URLEncoder.encode(str_date,"utf-8");

            Cookie cookie = new Cookie("lastTime", str_date);
            response.addCookie(cookie);
//                    设置cookie的存活时间
            cookie.setMaxAge(60*60*24*30);  //一个月
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<h1>您好欢迎首次访问</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
