package com.example.jdbctemplate;

import com.example.dao.IAccountDao;
import com.example.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2 获取对象
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        //3 执行操作
        Account account = accountDao.findAccountById(2);
        System.out.println(account);

//        account.setMoney(10000f);
//        accountDao.updateAccount(account);

    }
}

