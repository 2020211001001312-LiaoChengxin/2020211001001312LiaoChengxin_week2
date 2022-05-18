package com.LiaoChengxin.Lab1;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServletforLab1 extends HttpServlet {

    int counter;
    public LifeCycleServletforLab1(){
        System.out.println("I am form default constructor.");
    }

    @Override
    public void init(){
//        System.out.println(" I am in init()");
        counter = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(" i am in service () --> doGet() ");
        PrintWriter writer= response.getWriter();
        counter = counter + 1 ;
        writer.println("Since loading this servlet has been accessed " + counter + " times.");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy(){
        System.out.println(" I am in destroy()");
    }

}