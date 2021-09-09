package com.shf.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=100;
        int height=50;
//        1.创建一个对象，在内存中图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

//        2.美化图片
//        填充背景色
        Graphics graphics = image.getGraphics();
//        设置画笔颜色
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);

//        画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str="QWERTYUIOPASDFGHJKLZXCVBNM789456123qwertyuiopasdfghjklzxcvbnm";
//        生成随机角标
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
//        获取字符
            char c = str.charAt(index);

//        写验证码
            graphics.drawString(c+"",width/5*i,height/2);
        }

//        画干扰线
        graphics.setColor(Color.GREEN);
//        随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

//        3.将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
