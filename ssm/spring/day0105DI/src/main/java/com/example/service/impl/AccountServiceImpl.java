package com.example.service.impl;

import com.example.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }
}
