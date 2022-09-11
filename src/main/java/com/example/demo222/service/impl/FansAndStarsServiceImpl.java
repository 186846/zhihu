package com.example.demo222.service.impl;

import com.example.demo222.dao.FansAndStarsDao;
import com.example.demo222.entity.FansAndStars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FansAndStarsServiceImpl {
    @Autowired
    FansAndStarsDao fansAndStarsDao;

    //通过selectbystarname查询自己的粉丝集体
    public List<FansAndStars> selectbystarname(String starname){
        return fansAndStarsDao.selectbystarname(starname);
    }
    //通过selectbyfanname查询自己的偶像集体
    public List<FansAndStars> selectbyfanname(String fanname){
        return fansAndStarsDao.selectbyfanname(fanname);
    }
    //通过两个元素查找个体
    public FansAndStars selectbyname(FansAndStars fansAndStars){
       return fansAndStarsDao.selectbyname(fansAndStars);
    }
    //插入新的数据
    public FansAndStars insert(FansAndStars fansAndStars){
        fansAndStarsDao.insert(fansAndStars);
        return fansAndStars;
    }
    //<!--删除数据-->
    //在我的界面使用
    public int delete(FansAndStars fansAndStars){
        return fansAndStarsDao.delete(fansAndStars);
    }
}
