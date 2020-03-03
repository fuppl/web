package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.factory.BeanFactory;
import com.example.service.IAccountService;

import java.lang.reflect.InvocationTargetException;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao dao = new AccountDaoImpl();
//    private IAccountDao dao = (IAccountDao) BeanFactory.getBean("accountDao");

//    public AccountServiceImpl() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//    }

//    private int i = 1;
    public void saveAccount() {
        IAccountDao dao = (IAccountDao) BeanFactory.getBean("accountDao");

        int i = 1;
        dao.saveAccount();
        System.out.println(i);
        i++;
    }
}
