package com.example.dao;

import com.example.entity.Account;

import java.util.List;

/**
 * 账户持久层接口
 */
public interface IAccountDao {
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

    /**
     * 根据姓名查询账户
     * @param name
     * @return 如果有唯一结果就返回，如果没有返回null，如果多于一个抛异常
     */
    Account findByName(String name);


}
