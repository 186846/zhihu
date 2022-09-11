package com.example.demo222.service.impl;

import com.example.demo222.dao.FanCountDao;
import com.example.demo222.entity.Fan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FanCountServiceImpl {
    @Autowired
    FanCountDao fanCountDao;

    //查询
    public Fan selectByFanname(String fanname){
        return fanCountDao.selectByFanname(fanname);
    }

    //插入
    //在注册界面使用
    public Fan insert(Fan fan){
        fanCountDao.insert(fan);
        return fan;
    }

    //更新数据
    public int update(Fan fan){
        return fanCountDao.update(fan);
    }
}
