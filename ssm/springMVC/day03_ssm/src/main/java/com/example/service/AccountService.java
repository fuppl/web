package com.example.service;

import com.example.domain.Account;

import java.util.List;

/**
 * 用户业务层接口
 */
public interface AccountService {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    void save(Account account);
}
