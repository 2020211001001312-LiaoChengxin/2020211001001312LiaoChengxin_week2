package com.LiaoChengxin.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String text = request.getParameter("txt");
        String search = request.getParameter("search");

        if (text.equals("")){
            response.sendRedirect("/index.jsp");
        }
        else {
            if (search.equals("baidu"))
                response.sendRedirect("https://www.baidu.com/s?wd=" + text);
            else if (search.equals("bing"))
                response.sendRedirect("https://cn.bing.com/search?p=" + text);
            else if (search.equals("google"))
                response.sendRedirect("https://www.google.com/search?p=" + text);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
