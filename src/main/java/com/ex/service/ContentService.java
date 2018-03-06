package com.ex.service;

import com.ex.pojo.Content;

public interface ContentService {

    public Content getAndInsertContent(Double price, String title, String pic, String summary, String detail);

    public void updateContent(Content contentService);

    public Content getContent(int id);

    public void deleteContent(int id);

}
