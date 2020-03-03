package com.service;



import com.entity.Notice;

import java.util.List;

public interface NoticeService{
    /**
     *显示所有新闻
     */
    public List<Notice> listNotice();
    /**
     *添加新闻
     */
    public void addNotice(String content);
    /**
     *基于指定id获取新闻
     */
    public Notice getNotice(int id);
    /**
     *删除新闻
     */
    public void removeNotice(int id);
    /**
     *修改新闻
     */
    public void updateNotice(Notice notice);
}
