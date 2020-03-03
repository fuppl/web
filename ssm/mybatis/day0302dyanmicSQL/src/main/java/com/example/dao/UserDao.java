package com.example.dao;

import com.example.entity.QueryVo;
import com.example.entity.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户
     * @param userId
     */
    User findById(Integer userId);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 根据queryVo中的条件查询用户,todo 当查询条件多个时，把多个条件封装成一个类
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询的条件，可能时id，姓名，等，也有可能都有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的id集合查询
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
