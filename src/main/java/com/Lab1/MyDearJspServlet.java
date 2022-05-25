package com.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyDearJspServlet", value = "/MyDearJspServlet")
public class MyDearJspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Lab1/MyJsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String sName = request.getParameter("name");
            String sClass = request.getParameter("class");
            String sID = request.getParameter("ID");

            request.setAttribute("name",sName);
            request.setAttribute("class",sClass);
            request.setAttribute("ID",sID);
            request.getRequestDispatcher("Lab1/MyDearJsp.jsp").forward(request,response);
    }
}
