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
        sqlSession = factory.openSession();
        //4获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于再测试方法执行之后执行
    public void destory() throws IOException {
        //todo 提交；必须提交，否则回滚
        sqlSession.commit();
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
     * 测试保存操作
     */
    @Test
    public void SaveUserTest() throws IOException {
        User user = new User();
        user.setUsername("李景阳");
        user.setAddress("大庆市");
        user.setSex("1");
        System.out.println("保存前："+user);
        userDao.saveUser(user);
        System.out.println("保存后:"+user);
    }

    /**
     * 测试更新操作
     * @throws IOException
     */
    @Test
    public void UpdateUserTest() throws IOException{
        User user = new User();
        user.setId(5);
        user.setUsername("李老四");
        user.setAddress("大庆市");
        user.setSex("1");

        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     * @throws IOException
     */
    @Test
    public void DeleteUserTest() throws IOException{
        Integer id = 1;
        userDao.deleteUser(id);
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
     * 测试查询总人数
     * @throws IOException
     */
    @Test
    public void FindTotalTest() throws IOException{
        //todo 此处应提供 %
        Integer count = userDao.findTotal();
        System.out.println("用户总数为："+count);
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
}
