package com.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
urlPatterns = {"/Lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter --init()>");
    }

    public void destroy() {
        System.out.println("i am in LoginFilter --destroy()>");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LoginFilter --> request before chain");

        HttpServletRequest  req= (HttpServletRequest) request;
        HttpServletResponse  resp= (HttpServletResponse) response;
        if (req.getSession() != null && req.getSession().isNew()){
            request.getRequestDispatcher("/Lab2/welcome.jsp").forward(request,response);
        }else {
            resp.sendRedirect(req.getContextPath() + "/Lab2/login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println("LoginFilter --> request after chain");

    }
}
