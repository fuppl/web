package com.example.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("root");
        //1 创建对象
        JdbcTemplate jt = new JdbcTemplate();
        //给jt配置数据源
        jt.setDataSource(ds);
        //2 执行操作
        jt.execute("insert into account(name,money) values ('ddd',10000)");
    }
}

