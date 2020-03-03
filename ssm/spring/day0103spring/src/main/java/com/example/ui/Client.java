package com.example.ui;

import com.example.dao.IAccountDao;
import com.example.service.IAccountService;
import com.example.service.impl.AccountServiceImpl;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.lang.reflect.InvocationTargetException;

/**
 * 模拟一个表现层用于调用业务层
 */
public class Client {
    /**
     * todo 获取spring IOC的核心容器，并根据id获取对象
     *
     * todo ApplicationContext的三个常用实现类
     *  ClassPathXmlApplicationContext：可以加载类路径下的配置文件，要求配置文件必须在类路径下，否则加载不了
     *  FileSystemXmlApplicationContext：可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *  AnnotationConfigApplicationContext：用于读取注解创建容器
     *
     *  todo 核心容器的两个接口引发的问题
     *   ApplicationContext: 单例对象适用
     *      在建立核心容器时，创建对象采取的时立即加载的方式，也就是说，只要一读取完配置文件，马上就创建配置文件中配置的对象
     *   BeanFactory:       多例对象适用
     *      在建立核心容器时，在创建对象时采取延迟加载的方式，也就是说，什么时候根据id获取对象，再真正创建对象
     * @param args
     */
    public static void main(String[] args) {
//        // todo 1 获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        // 2根据id获取Bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountDao dao = (IAccountDao) ac.getBean("accountDao",IAccountDao.class);//todo 此处传入class利用反射，与强转效果相同
//
//        System.out.println(as);
//        System.out.println(dao);
//        as.saveAccount();
        //-------BeanFactory--------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        System.out.println(as);
    }
}
