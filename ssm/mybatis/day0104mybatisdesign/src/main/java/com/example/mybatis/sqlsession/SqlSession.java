package com.example.mybatis.sqlsession;

/**
 * 自定义mybatid里和数据库交互的核心类
 * 它可以自己创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T>T getMapper(Class<T> daoInterfaceClass);


    /**
     * 释放资源
     */
    void close();
}