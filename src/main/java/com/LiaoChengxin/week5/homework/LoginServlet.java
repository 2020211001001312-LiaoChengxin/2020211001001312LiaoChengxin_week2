package com.LiaoChengxin.week5.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con2=null;

    @Override
    public  void init() throws ServletException{
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con2= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in RegisterServlet "+con2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.init();
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String loginPassword = request.getParameter("loginPassword");

        PrintWriter writer= response.getWriter();

        PreparedStatement ps2= null;
        ResultSet rs2= null;
        boolean flag = true;
        try {
            String sql = "select * from usertable where username=? ";
            ps2 = con2.prepareStatement(sql);
            ps2.setString(1,loginName);
            rs2 = ps2.executeQuery();
            if (rs2.next()){
                String password = rs2.getString("password");
                if (loginPassword.equals(password)){
//                    writer.println("Login Success!!!\nWelcome,"+loginName);

                    request.setAttribute("id",rs2.getString("id"));
                    request.setAttribute("username",rs2.getString("username"));
                    request.setAttribute("password",rs2.getString("password"));
                    request.setAttribute("email",rs2.getString("email"));
                    request.setAttribute("gender",rs2.getString("gender"));
                    request.setAttribute("birthdate",rs2.getString("birthdate"));
                    request.getRequestDispatcher("userInfo.jsp").forward(request,response);

                }

                else
                    flag = false;
            }
            else
                flag = false;

            if (!flag)
            {
//                writer.println("Username or Password Error!!!");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }


        } catch (SQLException throwables1) {
            throwables1.printStackTrace();
        } finally {

            try {
                if (ps2 != null)
                    ps2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (rs2 != null)
                    rs2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }




        }
    }

    @Override
    public void destroy() {
        super.destroy();

        try {
            if (con2 != null)
                con2.close();
            System.out.println("Con2 Closed!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

