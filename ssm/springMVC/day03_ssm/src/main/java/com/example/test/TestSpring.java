package com.example.test;

import com.example.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
        //加载spring配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService as = ac.getBean("accountService",AccountService.class);
        //调用方法
        as.findAll();
    }
}
