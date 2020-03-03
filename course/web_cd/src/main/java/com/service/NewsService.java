package com.service;

import com.entity.News;

import java.util.List;

public interface NewsService {
    /**
     *显示所有新闻
     */
    public List<News> listNews();
    /**
     *添加新闻
     */
    public void addNews(String content);
    /**
     *基于指定id获取新闻
     */
    public News getNews(int id);
    /**
     *删除新闻
     */
    public void removeNews(int id);
    /**
     *修改新闻
     */
    public void updateNews(News news);
}
