package com.example.dao;

import com.example.entity.Account;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
    /**
     * 根据id查找账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查找账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);



}
