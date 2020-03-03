package com.example.test;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAnnoTest {
    /**
     * 测试基于注解的mybatis使用
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //1获取字节输入流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3生成SqlSession
        SqlSession session = factory.openSession();
        //4获取代理对象
        UserDao dao = session.getMapper(UserDao.class);
        //5执行到方法
        List<User> users = dao.findAll();
        for(User u : users){
            System.out.println(u);
        }
        //6释放资源
        session.close();
        in.close();
    }
}
