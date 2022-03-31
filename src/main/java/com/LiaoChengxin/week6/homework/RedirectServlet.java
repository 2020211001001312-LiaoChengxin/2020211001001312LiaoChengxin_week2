package com.LiaoChengxin.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Redirect Servlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("before redirect ");
//        1. start without /
//        response.sendRedirect("index.jsp");

//        2.start with /
//        response.sendRedirect("/index.jsp");
//        3.Absolute url
        response.sendRedirect("https://www.baidu.com/");
        System.out.println("after redirect ");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
