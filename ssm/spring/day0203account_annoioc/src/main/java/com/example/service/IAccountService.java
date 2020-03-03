package com.example.service;

import com.example.entity.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface IAccountService {


    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询用户
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存用户
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);
}
