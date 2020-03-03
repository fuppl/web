package com.example.test;

import com.example.dao.AccountDao;
import com.example.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //执行方法
        List<Account> accounts = dao.findAll();
        for (Account a:accounts){
            System.out.println(a);
        }
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("啦啦啦");
        account.setMoney(0d);

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建session对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //执行方法
        dao.saveAccount(account);
        session.commit();;
        //关闭资源
        session.close();
        in.close();
    }


}
