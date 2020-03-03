package com.example.test;

import com.example.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop配置
 */
public class AOPTest {
    public static void main(String[] args) {
        //1 获取容器
        ApplicationContext ac  = new ClassPathXmlApplicationContext("bean.xml");
        //2 获取对象
        IAccountService as = ac.getBean("accountService",IAccountService.class);
        //3 执行方法
        as.saveAccount();
    }
}
