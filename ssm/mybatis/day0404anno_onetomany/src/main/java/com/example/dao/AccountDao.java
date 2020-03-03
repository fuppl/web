package com.example.dao;

import com.example.entity.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap" ,value = {
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(column = "uid", property = "user", one = @One(select = "com.example.dao.UserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户id查询账户信息
     * @param uid
     * @return
     */
    @Select("select * from account where id = #{uid}")
    List<Account> findByUid(Integer uid);

}
