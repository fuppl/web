package com.example.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * todo
 *  Bean：在计算机英语中，有可重用组件的含义
 *  javabean:用java语言编写的可重用组件
 *      javabean >> 实体类
 *todo
 *  创建service类和dao对象
 *  第一个：需要一个配置文件来配置service和dao
 *    配置文件的内容：
 *         俄日一标志 = 全全限定类名（key = value）
 *  第二个：通过读取配置文件中的配置内容，反射创建对象
 *
 *  配置文件可选xml或peoperity文件均可
 */

public class BeanFactory {
    //定义一个properties对象
    private static Properties props;
    //todo 单例，定义一个map，用于存放要创建的对象，称之为容器
    private static Map<String, Object> beans;

    //使用静态代码块为properti对象赋值
    static {
        try {
        //实例化
        props = new Properties();
        //获取properties的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        props.load(in);
        //实力化容器
        beans = new HashMap<String, Object>();
        //取出配置文件中所有的key
        Enumeration keys = props.keys();

        //遍历枚举
        while(keys.hasMoreElements()){
            //取出
            String key = keys.nextElement().toString();
            //根据key获取value
            String beanPaeh = props.getProperty(key);
            //反射创建对象
            Object value = Class.forName(beanPaeh).getDeclaredConstructor().newInstance();
            //把key和value存入容器中
            beans.put(key, value);
        }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean名称获取bean对象
     * @param beanName bean名称
     * @return bean对象
     */
//    public static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Object bean = null;
//        String beanPath = props.getProperty(beanName);
//        bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
//        return bean;
//    }

    /**
     * 根据bean名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
