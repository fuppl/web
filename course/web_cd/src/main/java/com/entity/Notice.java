package com.entity;

import javax.xml.crypto.Data;

public class Notice {
    private int id;
    private String content;
    private Data insertTime;

    public Notice(int id, String content, Data insertTime) {
        this.id = id;
        this.content = content;
        this.insertTime = insertTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Data getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Data insertTime) {
        this.insertTime = insertTime;
    }
}
