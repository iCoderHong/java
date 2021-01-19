package com.ch.handle;

import com.ch.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局的异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理NameException
     * @param e 表示Controller抛出的异常对象
     */
    @ExceptionHandler(value = {NameException.class})
    public ModelAndView handleNameException(Exception e) {
        /**
         * 发生异常
         * 1.记录异常 记录到日志文件
         * 2.发送通知 邮件 短信
         * 3.给用户友好的提示
         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", e.getMessage());
        mv.setViewName("result");
        return mv;
    }

    /***
     * 处理未知异常
     */
    @ExceptionHandler
    public ModelAndView handleUnknowException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "服务异常 请稍后重试");
        mv.setViewName("result");
        return mv;
    }
}
