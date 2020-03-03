package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.entity.Account;
import com.example.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Account> findAllAccount() {
        return dao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return dao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        dao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        dao.deleteAccount(id);
    }


}
