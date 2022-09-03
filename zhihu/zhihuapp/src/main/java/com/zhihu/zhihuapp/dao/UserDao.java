package com.zhihu.zhihuapp.dao;

import com.zhihu.zhihuapp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    public void insertUser(@Param("user_name")String user_name,@Param("email")String email, @Param("password")String password);
    public User selectUser(@Param("email")String email,@Param("password")String password);
}