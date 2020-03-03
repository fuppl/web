package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 * todo 这是基于接口的动态代理，需要被代理对象（Producer类）至少实现一个接口，否则不能使用
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
         *  基于接口的动态代理
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象
         *      使用Proxy中的newProxyInstance方法
         *  要求：被代理类至少实现一个接口，否则不能使用
         *  newProxyInstance方法参数：
         *      Classloader：类加载器
         *          他是用来加载代理对象字节码的，写的是被代理对象的类加载器,固定写法
         *      Class[]：字节码数组
         *          他是用于让代理对象和被代理对象有相同方法,也是固定写法
         *      InvocationHandler：用于提供增强的代码
         *          它是让我们写如何代理，我们一般都是写一个该内部接口的实现类，通常为匿名内部类，但不必须
         *          此接口的实现类都是谁用谁写
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * todo 作用：执行任何被代理对象的任何接口方法都会经过该方法
                     *  方法参数的含义
                     * @param o        代理对象的引用
                     * @param method   当前执行的方法
                     * @param objects  当前执行方法所需的参数
                     * @return         和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
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
        proxyProducer.sellProduct(10000f);
    }
}
