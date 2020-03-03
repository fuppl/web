package com.example.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filepath
     * @return
     */
    public static InputStream getResourceAsStream(String filepath){
        /**
         * 过程分为三步：
         * .class获取当前类的字节码；
         * .getClassLoader根据字节码获取类的加载器；
         * .getResourcesAsStream根据类加载器读取配置
         */
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
