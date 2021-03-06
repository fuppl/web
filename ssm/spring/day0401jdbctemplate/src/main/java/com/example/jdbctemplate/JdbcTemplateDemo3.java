package com.example.jdbctemplate;

import com.example.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate的CRUD
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2 获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3 执行操作
        //保存
//        jt.update("insert into account(name,money) values (?,?)","fff",1500);

        //更新
//        jt.update("update account set name=?,money=? where id=?","ggg",5000,10);

        //删除
//        jt.update("delete from account where id=?", 10);

        //查询所有
//        List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(),100f);
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class),100f);
//        for(Account a : accounts){
//            System.out.println(a);
//        }

        //查询一个
//        List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class),2);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));

        //查询返回一行一列（使用聚合函数，但不加groupp by 字句）
        Integer count = jt.queryForObject("select count(*) from account where money > ?" , Integer.class,1000f);
        System.out.println(count);
    }
}

/**
 * 定义Account的封装策略
 */
class AccountRowMapper implements RowMapper<Account>{
    /**
     * 把结果集中的数据封装到Account中，然后又spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getDouble("money"));
        return account;
    }
}

