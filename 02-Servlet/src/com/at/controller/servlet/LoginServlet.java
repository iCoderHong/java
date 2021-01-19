package com.at.controller.servlet;

import com.sun.tools.corba.se.idl.StringGen;
import com.sun.tools.corba.se.idl.ValueBoxEntry;
import netscape.security.ParameterizedTarget;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.lang.ref.ReferenceQueue;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get请求发送请求 请求参数在请求头中 由Tomcat负责对二进制请求参数负责解码 Tocmat9.0 默认使用UTF-8进行解码 不会乱码
//        String usrename = request.getParameter("username");

//        response.setContentType("text/plan;charset=utf-8");
//        response.getWriter().write("欢迎" + usrename + "~~~~");

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Post请求发送请 请求参数在请求体中 由当前请求对象负责对二进制请求参数负责解码 默认的解码字符集是iSO-8859-1 会乱码
        // 解决乱码的方法 在读取请求参数前 告诉请求对象的字符集
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("Jack") && password.equals("123456")) {
             HttpSession session = request.getSession();
             session.setAttribute("islogin",true);
             response.sendRedirect("/servlet/home");
        } else {
            String errorMsg= "账号密码错误";
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

//        response.setContentType("text/plan;charset=utf-8");
//        response.getWriter().write("欢迎" + usrename + "~~~~");
    }

    private void method1(HttpServletRequest request, HttpServletResponse response) {
        String Url = request.getRequestURL().toString();
        System.out.println(Url); // http://localhost:8080/servlet/hello

        String URI = request.getRequestURI();
        System.out.println(URI); // /servlet/hello

        // 获取contextPath
        String contextPath1 = this.getServletContext().getContextPath();
        String contextPath2 = this.getServletConfig().getServletContext().getContextPath();
        String contextPath3 = request.getContextPath();

        // 获取请求头中所有的请求参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
        }
    }
}
