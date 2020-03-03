package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2使用session执行查询所有方法
        List<User> users = session.selectList("com.example.dao.UserDao.findAll");
        //3返回查询结果
        return users;
    }
}
