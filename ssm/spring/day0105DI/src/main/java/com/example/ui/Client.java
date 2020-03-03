package com.example.ui;

import com.example.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层用于调用业务层
 */
public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // todo 1 获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2根据id获取Bean对象
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        IAccountService as2 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as1 == as2);
        as1.saveAccount();
        //手动关闭容器
        ac.close();
    }
}
