package com.at.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 过滤器的路径配置
 */
@WebFilter(urlPatterns = {"/*", "/hello", "/img/*", "*.jpg", "/img/icon.jpg"})
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("HelloFilter destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 增强:对编码统一处理
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 通过拦截请求 对请求进行过滤
        chain.doFilter(request, response); // 放行请求
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("HelloFilter init");
    }

}
