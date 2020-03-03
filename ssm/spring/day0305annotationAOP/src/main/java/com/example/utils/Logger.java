package com.example.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于提供日志的工具类，里面提供了公共的代码
 */
@Component("logger")
@Aspect//todo 表示当前类是个切面类
public class Logger {
    @Pointcut("execution(* com.example.service.impl.*.*(..))")
    private void pt1(){}
    /**
     * 前置通知
     */
//    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始记录日志了");
    }

    /**
     * 后置通知
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始记录日志了");
    }

    /**
     * 异常通知
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger中的afterThrowingPrintLog方法开始记录日志了");
    }

    /**
     * 最终通知
     */
//    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterPrintLog方法开始记录日志了");
    }

    /**
     * todo 环绕通知
     *  问题：当我们配置了环绕通知之后，切入点代码没有执行，而通知方法执行了
     *  分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理中的环绕通知有明确的切入点（业务层）方法调用，而我们的代码中没有
     *  解决：
     *      Spring框架为我们提供了一个接口ProceedingJoinPoint。该接口有个方法叫proceed().此方法就相当于明确调用切入点方法
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用
     *  spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以手动控制增强代码何时执行的方式
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需的参数

            System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。前置");

            rtValue = pjp.proceed();//明确调用业务层方法（切入点方法）

            System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。后置");
            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。异常");
            throw new RuntimeException(t);

        }finally {
            System.out.println("Logger中的aroundPrintLog方法开始记录日志了。。最终");
        }
    }
}
