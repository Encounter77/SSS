package com.ex.dao;

import com.ex.pojo.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PersonDao {
    @Select("select * from person where userName = #{userName} and password = #{userPassword}")
    public Person getPerson(@Param("userName") String userName, @Param("userPassword") String userPassword);

    @Select("select password from person where userName = #{userName}")
    public String getUserPassword(String userName);

    @Select("select userType from person where userName = #{userName}")
    public int getUserType(String userName);

    @Select("select id from person where userName = #{userName}")
    public int getUserID(String userName);
}
