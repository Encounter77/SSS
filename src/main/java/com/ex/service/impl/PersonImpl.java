package com.ex.service.impl;

import com.ex.dao.PersonDao;
import com.ex.pojo.Person;
import com.ex.service.PersonService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class PersonImpl implements PersonService {

    @Resource
    private PersonDao personDao;


    public boolean isUser(String userName, String userPassword) {
        if (userPassword.equals(personDao.getUserPassword(userName))) {
            return true;
        }
        return false;
    }

    public int getType(String userName) {
        return personDao.getUserType(userName);
    }


    public String getUserPassword(String userName) {
        return personDao.getUserPassword(userName);
    }

    @Override
    public int getUserId(String userName) {
        return personDao.getUserID(userName);
    }

    @Override
    public Person getUser(String userName, String userPassword) {
        return personDao.getPerson(userName,userPassword);
    }
}
