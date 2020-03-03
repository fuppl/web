package com.example.cglib;

import com.example.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 * todo 这是传统的代理模式，需要被代理对象（Producer类）至少实现一个接口，否则不能使用
 */
public class Client {
    public static void main(String[] args) {
        // todo 匿名内部类访问外部成员变量时要求外部成员变量有final修饰
        final Producer producer = new Producer();
//        producer.sellProduct(10000f);

        /**
         * todo 动态代理的
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理
         *      涉及的类：Enhancer
         *      提供者：第三方Cglib库
         *  如何创建代理对象
         *      使用Enhancer中的create方法
         *  要求：被代理类不能时最终类
         *  create方法参数：
         *      Class：字节码
         *          他是用来用来指定被代理对象的字节码
         *      Callback：用于提供增强的代码
         *          它是让我们写如何代理，我们一般都是写一个该内部接口的实现类，通常为匿名内部类，但不必须
         *          此接口的实现类都是谁用谁写
         *          我们一般都是写该接口的子接口实现类：MethodInterceptor(方法拦截)
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * todo 执行被代理对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param objects
             *  以上三个参数和基于接口的动态代理方法中的invoke方法的参数相同
             * @param methodProxy ：todo 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //提供增强的代码:这里假设经销商拿走20%元作为利润，则厂家得到的利润为80%
                Object returnValue = null;
                //1 获取方法执行的参数
                Float money = (Float) objects[0];
                //2 判断当前方法是不是销售
                if ("sellProduct".equals(method.getName())){
                    returnValue = method.invoke(producer, money*0.8f);//todo 此处必须有是0.8f否则报错
                }
                return returnValue;
            }
        });
        cglibProducer.sellProduct(10000);
    }
}
