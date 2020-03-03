package com.entity;

public class User  {
    private int id;
    private String username;
    private boolean isadmin;

    public User(int id, String name, boolean isadmin) {
        this.id = id;
        this.username = name;
        this.isadmin = isadmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}
