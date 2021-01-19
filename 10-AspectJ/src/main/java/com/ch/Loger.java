package com.ch;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
public class Loger {

    //@Before("execution(public void com.ch.service.impl.UserServiceImpl.deleteById(String))")
    @Before("execution(void *..service.impl..*.*(String))")
    public void printStartTime() {
        System.out.println("begin time" + getCurrTime());
    }

    /*
        @After(value = "execution(int *..UserServiceImpl.updateById(String))")
        public void printEndTime(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("end time" + getCurrTime());
        }
    */

    /**
     * @Around
     * @param joinPoint
     * @return 决定目标方法的返回值
     */
    @Around(value = "execution(int *..UserServiceImpl.updateById(String))")
    public Object printEndTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("begin time" + getCurrTime());

        Object ret = joinPoint.proceed(); // method.invoke 执行目标方法

        System.out.println("end time" + getCurrTime());
        return 20;
    }

    private String getCurrTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
