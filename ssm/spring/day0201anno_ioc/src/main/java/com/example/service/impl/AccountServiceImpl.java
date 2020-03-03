package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.service.IAccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 账户的业务层实现类
 *
 *
 * 曾经xml的配置
 * <bean id="accountService" class="com.example.service.impl.AccountServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" | ref="" ></property>
 *  </bean>
 *
 * todo 注解分类
 *  用于创建对象的
 *      作用类似<bean>标签
 *      Component
 *          作用：用于把当前类对象存入spring容器中
 *          属性：value用于指定bean的id，当不写时，默认为当前类名，首字母小写
 *      Controller：一般用于表现层
 *      Service：一般用于业务层
 *      Repository：一般用于持久层
 *      以上三个注解的属性和作用与Component一模一样，
 *      它们三个时spring框架为我们提供明确的三层使用的注解，使我们的对象更加清晰
 *  用于注入数据的
 *      作用类似<property>
 *          Autowired
 *              作用：自动按照类型注入。只要容器中有唯一一个bean对象类型与要注入的变量类型匹配，就可以注入成功
 *                   没有则报错，如果有多个，则会比较属性名称与创建对象注解中value的值，相同则注入，无则报错
 *              位置：可以是变量上，也可以是方法上
 *              细节：在使用注解注入时，set方法就不是必须的了
 *          Qualifier
 *              作用：在按照类型注入的基础之上在按照名称注入，在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *              属性：
 *                  value:用于指定注入bean的id
 *          Resource
 *              作用：直接按照bean的id注入，可以独立使用
 *              属性：
 *                  name：用于指定bean的id
 *          以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解
 *          另外，集合类型的注入只能通过xml实现
 *          value
 *              作用：注入基本类型和string类型
 *              属性：
 *                  value：用于指定数据的值，可以使用spring中的SpEL（也就是spring的EL表达式）
 *                          SpEL写法${表达式}
 *  用于改变作用范围的
 *      作用类似<scope>
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围取值，常用取值
 *                  singleton（单例，默认） prototype（多例）
 *  和生命周期相关的(了解)
 *      作用类似init-method 和 destroy-method
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 *
 */
@Component(value = "accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao dao = new AccountDaoImpl();
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name="accountDao1")
    private IAccountDao accountDao;
//    public AccountServiceImpl(){
//        System.out.println("对象创建了");
//    }
    public void saveAccount() {
        accountDao.saveAccount();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("对象销毁了");
    }
}
