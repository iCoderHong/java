package com.at.controller.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ApplicationListener implements ServletContextListener, ServletContextAttributeListener {

    public ApplicationListener() { }

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println("======== 全局作用域对象初始化完成 ======== ");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("======== 全局作用域对象已销毁 ======== ");
    }

    // ServletContextAttributeListener implement

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("======== attributeAdded ======== ");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("======== attributeRemoved ======== ");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("======== attributeReplaced ======== ");
    }
}
