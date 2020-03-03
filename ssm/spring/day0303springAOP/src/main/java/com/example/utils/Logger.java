package com.example.utils;

/**
 * 用于提供日志的工具类，里面提供了公共的代码
 */
public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法执行前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger中的printLog方法开始记录日志了");
    }
}
