package com.example.mybatis.sqlsession.impl;

import com.example.mybatis.cfg.Configuration;
import com.example.mybatis.sqlsession.SqlSession;
import com.example.mybatis.sqlsession.proxy.MapperProxy;
import com.example.mybatis.utils.DataSourceUtil;
import javafx.beans.property.MapProperty;

import javax.sql.DataSource;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * SqlSession接口实现类
 */
public class SqlSessionImpl implements SqlSession {
    private Configuration cfg;
    private Connection conn;

    public SqlSessionImpl(Configuration cfg){
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn));
//        return null;
    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if(conn != null){
            try {
                conn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
