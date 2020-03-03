package com.example.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
    private Integer id;
    private String username;
    private Integer isadmin;
    private Timestamp insertime;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public Timestamp getInsertime() {
        return insertime;
    }

    public void setInsertime(Timestamp insertime) {
        this.insertime = insertime;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isadmin=" + isadmin +
                ", insertime=" + insertime +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
