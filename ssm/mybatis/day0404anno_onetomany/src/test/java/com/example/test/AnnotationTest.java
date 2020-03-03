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

    /**
     * 测试查询所有
     */
    @Test
    public void FindAllTest(){
        List<User> users = dao.findAll();
        for(User u : users){
            System.out.println(u);
            System.out.println(u.getAccounts());
        }
    }
    /**
     * 根据id查询用户
     */
    @Test
    public void FindByIdTest(){
        User user = dao.findById(15);
        System.out.println(user);

//        测试一级缓存
        User user1 = dao.findById(15);
        System.out.println(user1);

        System.out.println(user == user1);
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

}
