package com.LiaoChengxin.week4.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
//Week 4 Task 2
@WebServlet(name = "ConfigDemoServlet",urlPatterns = {"/config"},
        initParams = {
        @WebInitParam(name = "name",value = "LiaoChengxin"),
                @WebInitParam(name = "studentID",value = "2020211001001312")
        }
)//done



public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Week 4 Task 1 and 2
        ServletConfig config = getServletConfig();

        String name = config.getInitParameter("name");
        String studentId = config.getInitParameter("studentID");
        PrintWriter writer = response.getWriter();
        writer.println("<br> name: " + name);
        writer.println("<br> studentID: " + studentId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
