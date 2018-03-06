package com.ex.service.impl;

import com.ex.dao.ContentDao;
import com.ex.pojo.Content;
import com.ex.service.ContentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ContentImpl implements ContentService {

    @Resource
    private ContentDao contentDao;

    public Content getAndInsertContent(Double price, String title, String pic, String summary, String detail) {
        Content content = new Content();
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(pic);
        content.setSummary(summary);
        content.setDetail(detail);
        contentDao.insertPublic(content);
        content.setId(contentDao.getContentId(price, title, pic, summary, detail));
        return content;
    }

    public void updateContent(Content content) {
        contentDao.updateContent(content);
    }

    public Content getContent(int id) {
        return contentDao.getContent(id);
    }

    public void deleteContent(int id) {
        contentDao.deleteContent(id);
    }

}
