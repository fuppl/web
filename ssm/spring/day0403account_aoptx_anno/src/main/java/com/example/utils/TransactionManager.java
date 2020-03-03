package com.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了开启事务，提交事务，回滚事务和释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.example.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionUtils.getConnection().close();//todo 并非真正关闭，而是还回连接池
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //1 获取参数
            Object[] args = pjp.getArgs();
            //2 开启事务
            this.beginTransaction();
            //3 执行方法
            rtValue = pjp.proceed(args);
            //4 提交事务
            this.commit();
            return rtValue;
        }catch (Throwable t){
            //5 回滚事务
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            //6 释放资源
            this.release();
        }
    }
}
