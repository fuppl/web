package com.example.cglib;

import com.example.proxy.IProducer;

/**
 * 一个生产者
 */
public class Producer {

    /**
     * 销售
     * @param money
     */
    public void sellProduct(float money){
        System.out.println("销售产品并拿到钱 "+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱 "+money);
    }
}
