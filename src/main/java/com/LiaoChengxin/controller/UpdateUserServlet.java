package com.LiaoChengxin.controller;

import com.LiaoChengxin.dao.UserDao;
import com.LiaoChengxin.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con3 = null;

    @Override
    public void init() throws ServletException{
        con3 = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username ,password,email,gender;
        username = request.getParameter("username");
        password = request.getParameter("password");
        int id = Integer.parseInt(request.getParameter("id"));
        email = request.getParameter("email");
        gender = request.getParameter("gender");
        java.sql.Date  birthdate=java.sql.Date.valueOf(request.getParameter("birthdate"));
//        System.out.println(birthdate);
        User user = new User(id,username,password,email,gender,birthdate);
//        System.out.println(user==null);

        if (user!=null){

            UserDao userDao = new UserDao();
            try {
                userDao.updateUser(con3,user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

    }

    @Override
    public void destroy() {
        super.destroy();

        try {
            con3.close();
            System.out.println("Con3 Closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
