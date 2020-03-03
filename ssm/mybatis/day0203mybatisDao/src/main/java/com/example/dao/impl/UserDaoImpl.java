package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.entity.User;
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
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.example.dao.UserDao.findAll");//todo UserDao.xml中mapper的namespace加上方法名id
        //3释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用方法实现保存
        session.insert("com.example.dao.UserDao.saveUser",user);
        //3提交
        session.commit();
        //4释放资源
        session.close();
    }

    @Override
    public void updateUser(User user) {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用方法实现更新
        session.update("com.example.dao.UserDao.updateUser",user);
        //3提交
        session.commit();
        //4释放资源
        session.close();
    }

    @Override
    public void deleteUser(Integer userId) {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用方法实现删除
        session.delete("com.example.dao.UserDao.deleteUser",userId);
        //3提交
        session.commit();
        //4释放资源
        session.close();
    }

    @Override
    public User findById(Integer userId) {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用SqlSession中的方法，实现查询一个
        User user = session.selectOne("com.example.dao.UserDao.findById",userId);//todo UserDao.xml中mapper的namespace加上方法名id
        //3释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String username) {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用SqlSession中的方法，实现查询一个
        List<User> users = session.selectList("com.example.dao.UserDao.findByName",username);//todo UserDao.xml中mapper的namespace加上方法名id
        //3释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        //1根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2调用SqlSession中的方法，实现查询一个
        int count = session.selectOne("com.example.dao.UserDao.findTotal");//todo UserDao.xml中mapper的namespace加上方法名id
        //3释放资源
        session.close();
        return count;
    }
}
