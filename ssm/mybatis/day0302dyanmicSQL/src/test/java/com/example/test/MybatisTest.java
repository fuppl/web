package com.example.test;

import com.example.dao.UserDao;
import com.example.entity.QueryVo;
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
import java.util.ArrayList;
import java.util.List;

/**
 * 测试mybatis的CRUD操作
 */
public class MybatisTest  {

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
     * 测试查询所有
     * @throws IOException
     */
    @Test
    public void FindAllTest() throws IOException {
        List<User> users = userDao.findAll();

        for(User u : users){
            System.out.println(u);
        }
    }

    /**
     * 测试按id查询操作
     * @throws IOException
     */
    @Test
    public void FindByIdTest() throws IOException{
        User user = userDao.findById(14);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     * @throws IOException
     */
    @Test
    public void FindByNameTest() throws IOException{
        //todo 此处应提供 %
//        List<User> users = userDao.findByName("%李%");
        List<User> users = userDao.findByName("李");
        for(User u :users){
            System.out.println(u);
        }
    }

    /**
     * 测试queryVo
     * @throws IOException
     */
    @Test
    public void FindUserByVo() throws IOException{
        QueryVo queryVo = new QueryVo();
        User user = new User();
        queryVo.setUser(user);
        user.setUsername("%李%");
        List<User> users = userDao.findUserByVo(queryVo);
        for(User u :users){
            System.out.println(u);
        }
    }
    /**
     * 测试条件查询
     * @throws IOException
     */
    @Test
    public void FindUserByConditionTest() throws IOException {
        User user = new User();
        user.setUsername("%李%");
        List<User> users = userDao.findUserByCondition(user);

        for(User u : users){
            System.out.println(u);
        }
    }

    /**
     * 测试id数组查询查询
     * @throws IOException
     */
    @Test
    public void FindUserInIdsTest() throws IOException {
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();

        ids.add(4);
        ids.add(8);
        ids.add(9);
        ids.add(10);
        queryVo.setIds(ids);

        List<User> users = userDao.findUserInIds(queryVo);
        for(User u : users){
            System.out.println(u);
        }
    }
}
