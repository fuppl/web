package com.example.test;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationTest  {
    private SqlSessionFactory factory;
    private InputStream in;
    private UserDao dao;
    private SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        dao = session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void InsertTest(){
        User user = new User();
        user.setUsername("lalala");
        user.setSex("男");
        user.setAddress("保密");
        dao.saveUser(user);
    }

    /**
     * 更新用户测试
     */
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(16);
        user.setUsername("lalala");
        user.setSex("男");
        user.setAddress("你猜");
        dao.updateUser(user);
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser(){
        dao.deleteUser(16);
    }

    /**
     * 根据id查询用户
     */
    @Test
    public void FindByIdTest(){
        User user = dao.findById(15);
        System.out.println(user);
    }
    /**
     * 模糊查询用户
     */
    @Test
    public void FindByNameTest(){
        String string = "%李%";
        List<User> users = dao.findUserByName(string);
        for(User u : users){
            System.out.println(u);
        }
    }
    /**
     * 模糊查询用户
     */
    @Test
    public void FindTotalTest(){
        Integer count = dao.findTotal();
        System.out.println(count);
    }
}
