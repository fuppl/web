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
import java.util.List;

public class UserTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;
    @Before//用于再测试方法执行之前执行
    public void init() throws IOException {
        //1读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(in);
        //3获取SqlSession对象
        sqlSession = factory.openSession(true);//todo 创建SqlSession时可以传参true，这样即为自动提交
        //4获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于再测试方法执行之后执行
    public void destory() throws IOException {
        //todo 提交；必须提交，否则回滚
        //sqlSession.commit();
        //6释放资源
        sqlSession.close();
        in.close();
    }

    /**
     * 测试一级缓存
     */
    @Test
    public void FistLevelCacheTest(){
        User user = userDao.findById(8);
        System.out.println(user);

//        sqlSession.close();
        //此方法同上效果
        sqlSession.clearCache();
        //再次创建session
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

        User user1 = userDao.findById(8);
        System.out.println(user1);

        System.out.println(user == user1);
    }
    /**
     * 测试缓存的同步
     */
    @Test
    public void FistClearCacheTest(){
        //1根据id查询用户
        User user = userDao.findById(8);
        System.out.println(user);
        //2更新用户信息
        user.setUsername("updatecache");
        user.setAddress("lalala");
        userDao.updateUser(user);

        userDao = sqlSession.getMapper(UserDao.class);

        User user1 = userDao.findById(8);
        System.out.println(user1);

        System.out.println(user == user1);
    }

}
