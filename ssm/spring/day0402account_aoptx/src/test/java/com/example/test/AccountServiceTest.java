package com.example.test;

import com.example.entity.Account;
import com.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * 只用junit单元测试，测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void FindAllTest(){
        List<Account> accounts = as.findAllAccount();
        for(Account a : accounts){
            System.out.println(a);
        }
    }

    @Test
    public void TransferTest(){
        String sourceName = "aaa";
        String targetName = "bbb";

        as.transfer(sourceName, targetName, 500);

    }
}
