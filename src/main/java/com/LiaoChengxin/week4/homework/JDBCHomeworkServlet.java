package com.LiaoChengxin.week4.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebServlet(name = "JDBCHomeworkServlet",urlPatterns = {"/jdbc"},
//        initParams = {
//        @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb"),
//                @WebInitParam(name = "username",value = "sa"),
//                @WebInitParam(name = "password",value = "201312")
//        },
//        loadOnStartup = 1
//)//done

//@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)

public class JDBCHomeworkServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
//        String username="sa";
//        String password="201312";

        //加载驱动
//        ServletConfig config=getServletConfig();
//
//        String driver=config.getInitParameter("driver");
//        String url=config.getInitParameter("url");
//        String username=config.getInitParameter("username");
//        String password=config.getInitParameter("password");

        //demo #3 -use ServletContext
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCHomeworkServlet "+con);
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
