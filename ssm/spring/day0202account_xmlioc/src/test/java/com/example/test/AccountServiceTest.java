package com.example.test;

import com.example.entity.Account;
import com.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 只用junit单元测试，测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    //1获取容器
//    private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//    //2获取容器
//    private IAccountService as = ac.getBean("accountService",IAccountService.class);
    @Autowired
    private IAccountService as;

    @Test
    public void FindAllTest() {
        //3执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account a : accounts){
            System.out.println(a);
        }
    }

    @Test
    public void FindByIdTest() {
        //3执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void SaveAccountTest() {
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345);

        as.saveAccount(account);
    }

    @Test
    public void UpdateAccountTest() {
        Account account = as.findAccountById(4);
        account.setMoney(1000);
        as.updateAccount(account);
    }

    @Test
    public void DeleteAccountTest() {
        as.deleteAccount(4);
    }
}
