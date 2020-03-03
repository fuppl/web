package com.example.mybatis.cfg;

import java.util.Map;

/**
 * 自定义mybatis的配置类
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String,Mapper> mappers;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
//        this.mappers.putAll(mappers);//todo 此处需要使用追加的方法，而不是覆盖，否则mappers只有一个
        this.mappers = mappers;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
