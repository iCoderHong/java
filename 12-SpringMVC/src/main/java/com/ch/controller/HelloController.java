package com.ch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller 声明类为控制器
 */
@Controller
public class HelloController {
    public HelloController() {
        // 在web应用启动时spring负责创建
        System.out.println("=========== HelloController ===========");
    }

    /**
     * 定义控制器方法 处理请求
     * 形参 表示请求参数
     * 返回值 标识请求处理结果
     */
    @RequestMapping("/hello.do")
    public ModelAndView helloController() {
        // TODO:处理请求

        // 构建返回结果
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "666");
        // mv.setViewName("/WEB-INF/view/hello.jsp");
        // 配置了视图解析器 视图逻辑名称
        mv.setViewName("hello");
        return mv;
    }
}

/**
 * 请求流程分析
 * /hello.do ==> Tomcat接受请求 ==> DispatcherServlet分配 ==> HelloController
 */
