package com.example.factory;

import com.example.dao.IAccountDao;
import com.example.entity.Account;
import com.example.service.IAccountService;
import com.example.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager tsManager;

    public void  setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 用动态代理获取Service的代理对象
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param o
                     * @param method
                     * @param objects
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        if ("test".equals(method.getName())){
                            return method.invoke(accountService, objects);
                        }
                        Object rtValue = null;
                        try {
                            //1 开启事务
                            tsManager.beginTransaction();
                            //2 执行操作
                            rtValue = method.invoke(accountService, objects);
                            //3 提交事务
                            tsManager.commit();
                            //4 返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5 回滚操作
                            tsManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6 释放资源
                            tsManager.release();
                        }
                    }
                });
    }
}
