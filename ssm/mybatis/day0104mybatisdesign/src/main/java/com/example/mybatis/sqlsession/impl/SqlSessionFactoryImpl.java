package com.example.mybatis.sqlsession.impl;

import com.example.mybatis.cfg.Configuration;
import com.example.mybatis.sqlsession.SqlSession;
import com.example.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口实现类
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration cfg;
    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
