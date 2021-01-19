package com.at.controller.servlet;

import com.sun.org.apache.xml.internal.security.Init;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello", loadOnStartup = 1)
public class HelloServlet implements Servlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // http://localhost:8080/servlet/login
        // 一个web应用对应一个ServletContext实例，这个实例是应用部署启动后，servlet容器为应用创建的。
        // ServletContext实例包含了所有servlet共享的资源信息。通过提供一组方法给servlet使用，用来和servlet容器通讯，比如获取文件的MIME类型、分发请求、记录日志等
        // ServletContext context = this.config.getServletContext();
        // System.out.println(context.getContextPath()); // servlet
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}

