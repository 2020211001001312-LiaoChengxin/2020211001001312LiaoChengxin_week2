package com.Lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/Lab3/CalServlet")
public class CalServlet extends HttpServlet {

    public double Add(double firstVal ,double secondVal){
        return firstVal+secondVal;
    }

    public double subtract (double firstVal,double secondVal){
        return firstVal-secondVal;
    }

    public double multiply (double firstVal,double secondVal){
        return firstVal*secondVal;
    }
    public double divide (double firstVal,double secondVal){
        return firstVal/secondVal;
    }

    public int computeLength(String str){
        return str.length();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstVal = request.getParameter("firstVal");
        String secondVal = request.getParameter("secondVal");
        String name = request.getParameter("name");
        String action = request.getParameter("action");
        double result = 0.0;
        int length = 0;
        System.out.println(""+action+firstVal+secondVal);
        if (action.equals("Add")||action.equals("Subtract")||action.equals("Multiply")||action.equals("Divide")){

            if (action.equals("Add")){
                result = Add(Double.parseDouble(firstVal),Double.parseDouble(secondVal));

            }
            else if (action.equals("Subtract")){
                result = subtract(Double.parseDouble(firstVal),Double.parseDouble(secondVal));
            }
            else if (action.equals("Multiply")){
                result = multiply(Double.parseDouble(firstVal),Double.parseDouble(secondVal));
            }
            else if (action.equals("Divide")){
                result = divide(Double.parseDouble(firstVal),Double.parseDouble(secondVal));
            }

            Cookie cFirstVal = new Cookie("cFirstVal",firstVal);
            Cookie cSecondVal = new Cookie("cSecondVal",secondVal);
            Cookie cResult = new Cookie("cResult",Double.toString(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
        }
        else if (action.equals("ComputeLength")){
             length = computeLength(name);

            Cookie cName = new Cookie("cName",name);
            Cookie cLength = new Cookie("cLength",Integer.toString(length));

            cName.setMaxAge(5);
            cLength.setMaxAge(5);

            response.addCookie(cLength);
            response.addCookie(cName);

        }


        response.sendRedirect("cal.jsp");

    }
}
