package com.at.controller.servlet;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 重定向原理:在响应头添加字段location:"/servlet/index.html" 并且设置响应状态码302
        // response.setStatus(302);
        // response.setHeader("location", "/servlet/index.jsp");

        // 重定向
        // response.sendRedirect("/servlet/index.jsp"); // 重定向内部jsp资源
        // response.sendRedirect("/servlet/index.html"); // 重定向内部html资源
        // response.sendRedirect("/servlet/hello"); // 重定向Servlet动态资源
        // response.sendRedirect("https://www.baidu.com"); // 重定向外部网址

        // 请求转发
        // request.getRequestDispatcher("/index.jsp").forward(request, response);
        // request.getRequestDispatcher("/index.html").forward(request, response);
        // request.getRequestDispatcher("/login").forward(request, response);

        // 注意:重定向与请求转发路径的写法

        // response.getWriter().write("Hello UserServlet");
        ServletOutputStream outputStream = response.getOutputStream(); // 字节流
        outputStream.write(69);
        // PrintWriter writer = response.getWriter(); // 字符流
    }
}
