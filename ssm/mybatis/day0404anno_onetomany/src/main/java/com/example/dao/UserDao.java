package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.javassist.bytecode.analysis.ControlFlow;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 *  todo 在mybatis中，针对CRUD提供四个注解
 *  分别是 @Select @Update @Insert @Delete
 */
//todo 开启二级缓存
@CacheNamespace(blocking = true)
public interface UserDao  {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "id", property = "accounts",many = @Many(select = "com.example.dao.AccountDao.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
//    todo 此处可以引用一个数组
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{name}")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String name);

}
