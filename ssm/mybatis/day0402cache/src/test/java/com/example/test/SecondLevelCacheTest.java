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
    private InputStream in;
    private SqlSessionFactory factory;

    @Before//用于再测试方法执行之前执行
    public void init() throws IOException {
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);

    }

    @After//用于再测试方法执行之后执行
    public void destory() throws IOException {

        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void testSecondLevelCache(){
        SqlSession session = factory.openSession();
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.findById(8);
        System.out.println(user);
        session.close();//一级缓存消失

        SqlSession session1 = factory.openSession();
        UserDao userDao1 = session1.getMapper(UserDao.class);
        User user1 = userDao1.findById(8);
        System.out.println(user1);
        session1.close();

        System.out.println(user == user1);
    }

}
