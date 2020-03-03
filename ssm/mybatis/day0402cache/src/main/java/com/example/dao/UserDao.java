package com.example.dao;

import com.example.entity.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户,同时获取到账户信息
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 测试当缓存中数据与数据库不一致时mybatis如何实现同步
     * @param user
     */
    void updateUser(User user);

}
