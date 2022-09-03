package com.zhihu.zhihuapp.controller;

import com.zhihu.zhihuapp.model.User;
import com.zhihu.zhihuapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImp;

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/dologin")
    public String doLogin(User user, Map<String,Object> map){
        User user1 = userServiceImp.selectUser(user.getEmail(),user.getPassword());
        System.out.println(user1);
        if(user1==null){
            map.put("msg","密码或账户错误！");
            return "fail";
        }else{
            map.put("mag","登入成功");
            return "success";
        }
    }

    @RequestMapping("/doregister")
    public String doRegister(User user,Map<String,Object> map){
            User user1 = userServiceImp.selectUser(user.getEmail(),user.getPassword());
            if (user1 ==null){
                userServiceImp.insertUser(user.getUser_name(),user.getEmail(),user.getPassword());
                map.put("msg","注册成功");
                return "success";
            }else {
                map.put("msg","该用户已存在！");
                return "fail";
            }
    }
}