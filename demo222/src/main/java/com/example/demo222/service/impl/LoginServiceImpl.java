package com.example.demo222.service.impl;

import com.example.demo222.entity.Login;
import com.example.demo222.repository.MyRepository;
import com.example.demo222.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    MyRepository loginRepository;
    @Override
    public List<Login> findAll() {
        return null;
    }
    //登陆
    @Override
    public List<Login> findByUsernameAndUserpassword(String username, String userpassword) {
        return loginRepository.findByUsernameAndUserpassword(username,userpassword);
    }
   // 注册
    @Override
    public void save(Login login) {
        loginRepository.save(login);
    }
     //查用户名
    @Override
    public List<Login> findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }
}
