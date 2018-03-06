package com.ex.dao;

import com.ex.pojo.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface TransactionDao {
    @Select("select * from trx where contentId = #{id};")
    public Transaction getTransaction(int id);

    @Insert("insert into trx (contentId,personId,price,time) values (#{contentId},#{personId},#{price},#{time});")
    public void InsertTransaction(Transaction transaction);

    @Update("update trx set price = #{price},num = #{num},time = #{time} where id = #{id}")
    public void updateTransaction(Transaction transaction);
}
