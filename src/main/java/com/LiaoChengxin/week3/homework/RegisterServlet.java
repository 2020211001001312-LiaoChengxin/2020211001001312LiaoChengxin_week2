package com.LiaoChengxin.week3.homework;

import jdk.nashorn.internal.ir.WhileNode;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;

    @Override
    public  void init() throws ServletException{
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in RegisterServlet "+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");
        PreparedStatement ps = null;

        String sql = "insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,"2");
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setString(6,birthdate);
            ps.execute();
            System.out.println("insert --> OK !");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//Print rows in a new page (webapp/week4/users_list.jsp)
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<users> list = new ArrayList<users>();
        try {
            sql = "select * from usertable";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username2 = resultSet.getString("username");
                String password2 = resultSet.getString("password");
                String email2 = resultSet.getString("email");
                String gender2 = resultSet.getString("gender");
                String birthdate2 = resultSet.getString("birthdate");
                users user = new users(id,username,password,email,gender,birthdate);
                list.add(user);
            }
            for (users user : list){
                System.out.println(user);
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } finally {

            try {
                if(preparedStatement!=null)
                    preparedStatement.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resultSet!=null)
                    resultSet.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("list",list);
        request.getRequestDispatcher("week4/users_list.jsp").forward(request,response);


    }

    @Override
    public void destroy() {
        super.destroy();

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
