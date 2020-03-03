package com.example.dao.impl;

import com.example.dao.IAccountDao;
import com.example.entity.Account;
import com.example.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return runner.query(connectionUtils.getConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
             runner.update(connectionUtils.getConnection(),"insert into account(name,money)value(?,?)", account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"update account set name=? ,money = ? where id = ?", account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getConnection(),"delete from  account where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findByName(String name) {
        try {
            List<Account> accounts =  runner.query(connectionUtils.getConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class),name);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不为一，数据有问题");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
