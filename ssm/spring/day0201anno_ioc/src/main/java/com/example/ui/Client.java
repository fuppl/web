package com.example.ui;

import com.example.dao.IAccountDao;
import com.example.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        // 1 获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2 根据id获取Bean对象

        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        System.out.println(as);
//
//        IAccountDao dao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(dao);

//        System.out.println(as == as1);

        as.saveAccount();
        ac.close();
    }
}
