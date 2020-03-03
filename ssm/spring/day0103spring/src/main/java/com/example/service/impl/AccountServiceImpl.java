package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    public void saveAccount() {
        dao.saveAccount();
    }
}
