package com.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LiaoChengxinFilter")
public class LiaoChengxinFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiaoChengxin LoginFilter --> request before chain");
        chain.doFilter(request, response);
        System.out.println("LiaoChengxin LoginFilter --> request after chain");
    }
}
