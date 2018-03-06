package com.ex.dao;

import com.ex.pojo.Content;
import org.apache.ibatis.annotations.*;

public interface ContentDao {

    @Insert("insert into content (price,title,icon,abstract,text) values (#{price},#{title},#{pic},#{summary},#{detail});")
    public void insertPublic(Content content);

    @Select("select id from content where price = #{price} and title = #{title} and " +
            "icon = #{icon} and abstract = #{summary} and text = #{detail}")
    public int getContentId(@Param("price") Double price,
                            @Param("title") String title,
                            @Param("icon") String pic,
                            @Param("summary") String summary,
                            @Param("detail")String detail);

    @Select("select * from content where id = #{id}")
    @Results({
            @Result(property = "summary", column = "abstract"),
            @Result(property = "pic", column = "icon"),
            @Result(property = "detail", column = "text"),
            @Result(property = "price", column = "price")
    })
    public Content getContent(int id);

    @Update("update content set price = #{price}, title = #{title}, icon = #{pic}, abstract = #{summary}, text = #{detail} where id = #{id}")
    public void updateContent(Content content);

    @Delete("delete from content where id = #{id}")
    public void deleteContent(int id);
}
