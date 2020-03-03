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

import java.io.IOException;
import java.io.InputStream;

public class SecondLevelCacheTest {
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
        in.close();
    }
    /**
     * 根据id查询用户
     */
    @Test
    public void FindByIdTest(){
        User user = dao.findById(15);
        System.out.println(user);

        session.close();//释放一级缓存
        session = factory.openSession();
        UserDao dao1 = session.getMapper(UserDao.class);
        User user1 = dao1.findById(15);
        System.out.println(user1);
        System.out.println(user==user1);

    }
}
