package com.example.dao.ui;

import com.example.factory.BeanFactory;
import com.example.service.IAccountService;
import com.example.service.impl.AccountServiceImpl;

import java.lang.reflect.InvocationTargetException;

/**
 * 模拟一个表现层用于调用业务层
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //不解耦
        //        IAccountService as = new AccountServiceImpl();
        //解耦
        //IAccountService as = (IAccountService)BeanFactory.getBean("accountService");
        //as.saveAccount();


        for( int i=0;i<5;i++){
            IAccountService as = (IAccountService)BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
