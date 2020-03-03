package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  todo 在mybatis中，针对CRUD提供四个注解
 *  分别是 @Select @Update @Insert @Delete
 */
public interface UserDao  {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,sex,address)values(#{username},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{username}, sex = #{sex}, address = #{address} where id =#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id =#{id}")
    void deleteUser(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Select("select * from user where username like #{name}")
    List<User> findUserByName(String name);

    /**
     * 查询记录条数
     * @return
     */
    @Select("select count(*) from user")
    Integer findTotal();
}
