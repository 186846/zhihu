package com.example.demo222.service.impl;

import com.example.demo222.dao.StarCountDao;
import com.example.demo222.entity.Star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarCountServiceImpl {
    @Autowired
    StarCountDao starCountDao;

    //查找
    public Star selectByStarname(String starname){
        return starCountDao.selectByStarname(starname);
    }
    //插入
    //在注册界面使用
    public Star insert(Star star){
        starCountDao.insert(star);
        return star;
    }
    //更新
    public int update(Star star){
       return starCountDao.update(star);
    }
}
