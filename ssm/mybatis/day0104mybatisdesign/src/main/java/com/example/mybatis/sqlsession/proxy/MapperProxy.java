package com.example.mybatis.sqlsession.proxy;

import com.example.mybatis.cfg.Mapper;
import com.example.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy (Map<String,Mapper> mappers,Connection conn){
        this.mappers = mappers;
        this.conn = conn;
    }
    /**
     * 用于对方法进行增强的，我的增强就是调用selectList方法
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //1获取方法名
        String methodName = method.getName();
        //2获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3组合key
        String key = className+"."+methodName;
        //4获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5判断是否有mapper
        if(mapper == null){
            //传的参数有问题
            throw new IllegalArgumentException("传入的参数有误");
        }
        //6调用工具类执行查询所有
        return new Executor().selectList(mapper,conn);
    }
}
