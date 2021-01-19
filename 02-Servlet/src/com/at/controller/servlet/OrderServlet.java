package com.at.controller.servlet;

import com.sun.tools.doclets.internal.toolkit.taglets.PropertySetterTaglet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.time.temporal.ValueRange;
import java.util.Enumeration;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Servlet共享数据 四大域对象
         * ServletContext接口
         *    每一个网站都存在ServletContext是全局作用域对象 所有servlet可以共享数据
         *    全局作用域声明周期:
         *       在Http启动过程中 自动为当前网站创建一个全局作用域对象
         *       Http服务器准备关闭时,将当前网站中的全局作用域对象销毁
         *       全局作用域对象声明周期贯穿网站整个运行期间
         *       *****ServletContext底层存储本质是Map 占用服务器计算机内存*****
         *
         * Cookie类
         *      存放当前用户的私人数据
         *      Cookie数据是存储在客户端
         *      键值类型必须是String 键值不能是中文
         * HTTPSession接口
         *      session会话作用域对象
         *      session数据是存储在服务端计算机 cookie是存储在客户端计算机中
         *      session可以存储任意数据类型 cookie只能存储字符串类型
         *      一个cookie对象只能存储一个键值对 session可以存放任意键值对(内部使用的map)
         * HTTPServletRequest接口
         *      请求转发 两个Servle共享请求数据包
         *      request.getRequestDispatcher("/login").forward(request, response);
         */

//         ServletContext application = request.getServletContext();
//         application.setAttribute("name", "jack");
//         application.removeAttribute("name");

//        Cookie cookie = new Cookie("order", "002");
//        cookie.setDomain("localhost");
//        cookie.setMaxAge(60); // 默认session 当前对话有效 手动设置后Cookie存放在客户端计算机的硬盘上
//        cookie.setPath("/servlet/order"); // 默认整个web /servlet
//        response.addCookie(cookie);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) { // 防止空指针异常
            for (Cookie c : cookies) {
                System.out.println("==============Cookie==============");
                System.out.println(c.getName() + " : " + c.getValue());
                System.out.println("==================================");
            }
        }

        HttpSession session = request.getSession(false); // false默认不会创建
        System.out.println(session);

        // 调用请求对象向Tomcat获取当前用户在服务端的session对象
        // HttpSession session = request.getSession();
        // HttpSession session = request.getSession(false); // false默认不会创建

        // Cookie: JSESSIONID=974DA1C2D33C5EB5CEDCE93BD5F87FC0

        /*
            tomcat默认配置 conf/web.xml 30分钟
            <session-config>
            <session-timeout>30</session-timeout>
            </session-config>
            自定义可以在工程web.xml配置
         */

//        String name = (String) session.getAttribute("orderId");
//        if (name == null) {
//            session.setAttribute("orderId", "432749274392749832");
//        }

//        Enumeration<String> names = session.getAttributeNames();
//        while (names.hasMoreElements()) {
//            System.out.println(session.getAttribute(names.nextElement()));
//        }

        // 请求作用域对象
//        request.setAttribute("uid", 1000343948);
//        request.getAttribute("uid");

//        Enumeration<String> attributeNames = request.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            System.out.println(attributeNames.nextElement());
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
