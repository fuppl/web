package com.example.test;

import com.example.dao.AccountDao;
import com.example.dao.UserDao;
import com.example.entity.Account;
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

public class AccountTest {
    private SqlSessionFactory factory;
    private InputStream in;
    private AccountDao dao;
    private SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        dao = session.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void FindAllTest(){
        List<Account> accounts = dao.findAll();
        for(Account a :accounts){
            System.out.println(a);
            System.out.println(a.getUser());
        }
    }

}
