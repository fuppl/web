package com.example.dao;

import com.example.entity.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findALL();
}
