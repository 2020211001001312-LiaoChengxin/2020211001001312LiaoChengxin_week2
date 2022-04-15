package com.LiaoChengxin.week5.homework;

import com.LiaoChengxin.dao.UserDao;
import com.LiaoChengxin.model.User;

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
            System.out.println("Connection --> in LoginServlet "+con2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        super.init();
//        doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("loginName");
        String loginPassword = request.getParameter("loginPassword");

//        MVC code
        UserDao userDao = new UserDao();
        try {
           User user = userDao.findByUsernamePassword(con2,loginName,loginPassword);
           if (user!=null)
           {
//               Week 8 demo2-- Use cookie for session
//               Cookie c=new Cookie("sessionid",""+user.getId());
//               c.setMaxAge(10*60);
//               response.addCookie(c);

//               add code for rememberMe
               String rememberMe = request.getParameter("rememberMe");
//               System.out.println(rememberMe.equals("1"));
               if(rememberMe!=null && rememberMe.equals("1")){
                   Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                   Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                   Cookie rememberMeCookie = new Cookie("cRememberMe",rememberMe);

                   usernameCookie.setMaxAge(5);
                   passwordCookie.setMaxAge(5);
                   rememberMeCookie.setMaxAge(5);

                   response.addCookie(usernameCookie);
                   response.addCookie(passwordCookie);
                   response.addCookie(rememberMeCookie);
           }

//              Week 8 demo2
               HttpSession session = request.getSession();
               //check session id
               System.out.println("session id-->"+session.getId());
               session.setMaxInactiveInterval(10);


              session.setAttribute("user",user);// get user info in jsp.
               request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
           }else {
               request.setAttribute("message","Username or Password Error!!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }

// ------------------------------------------------
//        PrintWriter writer= response.getWriter();
//
//        PreparedStatement ps2= null;
//        ResultSet rs2= null;
//        boolean flag = true;
//        try {
//            String sql = "select * from usertable where username=? ";
//            ps2 = con2.prepareStatement(sql);
//            ps2.setString(1,loginName);
//            rs2 = ps2.executeQuery();
//            if (rs2.next()){
//                String password = rs2.getString("password");
//                if (loginPassword.equals(password)){
////                    writer.println("Login Success!!!\nWelcome,"+loginName);
//
//                    request.setAttribute("id",rs2.getString("id"));
//                    request.setAttribute("username",rs2.getString("username"));
//                    request.setAttribute("password",rs2.getString("password"));
//                    request.setAttribute("email",rs2.getString("email"));
//                    request.setAttribute("gender",rs2.getString("gender"));
//                    request.setAttribute("birthdate",rs2.getString("birthdate"));
//                    request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//
//                }
//
//                else
//                    flag = false;
//            }
//            else
//                flag = false;
//
//            if (!flag)
//            {
////                writer.println("Username or Password Error!!!");
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//
//
//        } catch (SQLException throwables1) {
//            throwables1.printStackTrace();
//        } finally {
//
//            try {
//                if (ps2 != null)
//                    ps2.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (rs2 != null)
//                    rs2.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//
//
//        }
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

