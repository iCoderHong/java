package com.ch;

import com.ch.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectJ {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserService service = context.getBean(IUserService.class);
        System.out.println(service.updateById("10"));
    }
}
