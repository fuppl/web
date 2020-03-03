package com.example.test;

import com.example.entity.Account;
import com.example.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 只用junit单元测试，测试配置
 *
 * todo spring整合junit的配置
 *      1导入spring整合junit的jar包（坐标）
 *      2使用junit提供的注解把原有的main方法替换成spring提供的
 *          @Runwith
 *      3告知spring的运行器，spring的ioc创建是基于xml的，还是基于注解的，并说明位置
 *          @ContextConfiguration
 *              locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在位置
 *      细节：spring5.x版本要求junit版本高于或等于4.12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as ;

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
        account.setName("test anno");
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
