package com.zhihu.zhihuapp.service;

import com.zhihu.zhihuapp.dao.UserDao;
import com.zhihu.zhihuapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    public UserDao userDao;

    public boolean insertUser(String user_name,String email,String password){
        System.out.println(user_name+" "+email+" "+password);
        userDao.insertUser(user_name,email,password);
        return true;
    }

    public User selectUser(String email, String password){
        System.out.println(email+" " +password);
        return userDao.selectUser(email,password);
    }
}