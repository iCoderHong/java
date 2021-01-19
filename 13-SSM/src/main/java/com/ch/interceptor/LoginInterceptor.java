package com.ch.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HandlerExecutionChain 多个拦截器链条

/**
 * 拦截器
 * 拦截器和过滤器的对比:
 *  1.拦截器是Spring框架中提供的 而过滤器是Servlet规范中提供的
 *  2.拦截器是对contoller动态资源请求的 而过滤器可以对所有动态的和静态进行过滤
 *  3.执行优先级  过滤器 --> 中央调度器 --> 拦截器
 *  4.拦截器侧重于对请求做判断 处理的 可以截断请求 顾虑器侧重于对request response对象的属性
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * preHandle 预先处理的请求方法
     * @param request
     * @param response
     * @param handler 被拦截的Controller对象
     * @return
     * @throws Exception
     *
     * 预处理方法是在Controller方法之前先执行的 可以对请求检查 数据统计
     *
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========== preHandle ==========");
        return true;
    }

    /**
     * postHandle 后处理方法
     * @param request
     * @param response
     * @param handler 被拦截的Controller对象
     * @param modelAndView Controller方法的返回值(请求的结果)
     * @throws Exception
     *
     * 在Controller方法之后先执行的 它可以获取控制器方法执行的结果 可以修改返回的结果
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("========== postHandle ==========");
    }

    /**
     * afterCompletion最后执行的方法
     * @param request
     * @param response
     * @param handler 被拦截的Controller对象
     * @param ex 异常对象
     * @throws Exception
     *
     * 在请求处理完成后执行的 请求处理完成标示(视图处理完成 对视图执行forward操作后)
     * 可以做程序最后要做的工作 比如 释放内容 清理临时变量
     * 方法执行的条件
     *  1.preHandle执行 2.并且返回值为true
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("========== afterCompletion ==========");
    }
}
