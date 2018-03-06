package com.ex.service;


import com.ex.pojo.Person;

public interface PersonService {

    public boolean isUser(String userName, String userPassword);

    public int getType(String userName);

    public String getUserPassword(String userName);

    public int getUserId(String userName);

    public Person getUser(String userName,String userPassword);

}
