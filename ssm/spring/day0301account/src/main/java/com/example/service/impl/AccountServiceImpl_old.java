package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.entity.Account;
import com.example.service.IAccountService;
import com.example.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_old implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager tsManager;


    public void setDao(IAccountDao dao) {
        this.accountDao = dao;
    }

    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //3 提交事务
            tsManager.commit();
            //4 返回结果
            return accounts;
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6 释放资源
            tsManager.release();
        }

    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作
            Account account = accountDao.findAccountById(id);
            //3 提交事务
            tsManager.commit();
            //4 返回结果
            return account;
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6 释放资源
            tsManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作
            accountDao.saveAccount(account);
            //3 提交事务
            tsManager.commit();
            //4 返回结果
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
        } finally {
            //6 释放资源
            tsManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作
            accountDao.updateAccount(account);
            //3 提交事务
            tsManager.commit();
            //4 返回结果
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
        } finally {
            //6 释放资源
            tsManager.release();
        }

    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作
            accountDao.deleteAccount(id);
            //3 提交事务
            tsManager.commit();
            //4 返回结果
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
        } finally {
            //6 释放资源
            tsManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {

        try {
            //1 开启事务
            tsManager.beginTransaction();
            //2 执行操作

            //2.1根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //2.2根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //2.3转出账户减钱
            source.setMoney(source.getMoney() - money);
            //2.4转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5更新转出账户
            accountDao.updateAccount(source);
            int i = 1/0;
            //2.6更新转入账户
            accountDao.updateAccount(target);

            //3 提交事务
            tsManager.commit();
            //4 返回结果
        } catch (Exception e) {
            //5 回滚操作
            tsManager.rollback();
            e.printStackTrace();
        } finally {
            //6 释放资源
            tsManager.release();
        }



    }


}
