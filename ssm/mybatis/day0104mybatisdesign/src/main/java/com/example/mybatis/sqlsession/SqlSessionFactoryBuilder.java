package com.example.mybatis.sqlsession;

import com.example.mybatis.cfg.Configuration;
import com.example.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import com.example.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSession工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new SqlSessionFactoryImpl(cfg);
    }
}
