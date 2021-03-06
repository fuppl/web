package com.example.test;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.mybatis.io.Resources;
import com.example.mybatis.sqlsession.SqlSession;
import com.example.mybatis.sqlsession.SqlSessionFactory;
import com.example.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂类
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.工厂类创建SqlSession对象
        SqlSession session = factory.openSession();
        //4.使用SqlSession创建UserDao代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for(User u :users){
            System.out.println(u);
        }
        //6.释放资源
        session.close();
        in.close();
    }
}
