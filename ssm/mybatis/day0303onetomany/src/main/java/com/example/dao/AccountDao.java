package com.example.dao;

import com.example.entity.Account;
import com.example.entity.AccountUser;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有,还要获取到当前账户所属用户名
     * @return
     */
    List<Account> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 查询所有账户，并带有用户名和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
