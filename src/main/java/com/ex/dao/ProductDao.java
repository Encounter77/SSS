package com.ex.dao;

import com.ex.pojo.Product;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductDao {

    @Select("select * from content")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text")
    })
    public List<Product> getProductList();

    @Select("select * from content where id = #{id}")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text")
    })
    public Product getProduct(int id);
}
