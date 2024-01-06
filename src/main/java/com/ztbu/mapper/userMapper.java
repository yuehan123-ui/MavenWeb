package com.ztbu.mapper;

import com.ztbu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface userMapper {
    @Select("select * from tb_user where username = #{username} and `password` = #{password};")
    User selectByusername (@Param("username") String username,@Param("password")String password);
    @Insert("insert into tb_user(username,`password`) values (#{username},#{password})")
    void insert(User user);

    @Select("select * from tb_user where username = #{username};")
    User selectByUsername (@Param("username") String username);

}
