package com.example.dao;

import com.example.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户持久层接口
 */
@Repository
public interface AccountDao {
    /**
     * 返回所有账户
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     * @param account
     */
    @Insert("insert into account(name,money) values (#{name},#{money})")
    void saveAccount(Account account);



}
