package com.LiaoChengxin.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//way 1 -use web.xml
//way 2 -use WebFilter
@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}
)
//task 1 : url /hello
//task 2 : url /*
//task 3 : url this filter for these 3 url only
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");
    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter-->doFilter()--before");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter-->doFilter()--after");
    }
}
