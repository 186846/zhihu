package com.example.demo222.service;

import com.example.demo222.entity.Login;

import java.util.List;

public interface LoginService {
        List<Login> findAll();
        //登陆
        List<Login> findByUsernameAndUserpassword(String username ,String userpassword);
        //注册
        void save(Login login);
         List<Login> findByUsername(String username);
}
