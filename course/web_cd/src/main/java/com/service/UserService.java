package com.service;

import com.entity.User;

import java.util.List;

public interface UserService  {
    /**
     *显示所有用户
     */
    public List<User> listUsers();
    /**
     *添加用户
     */
    public void addUser(String name);
    /**
     *基于指定id获取用户
     */
    public User getUser(int id);
    /**
     *删除用户
     */
    public void removeUser(int id);
    /**
     *修改用户
     */
    public void updateUser(User user);
}
