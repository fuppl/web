package com.example.dao;

import com.example.entity.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有,还要获取到当前账户所属用户名
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    List<Account> findAccountByUid(Integer uid);
}
