package com.example.demo222.service.impl;

import com.example.demo222.dao.CollectionCountDao;
import com.example.demo222.entity.CollectionCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionCountServiceImpl {
    @Autowired
    CollectionCountDao collectionCountDao;

    //根据topicid查询收藏数量信息
    public CollectionCount selectById(int topicid){
        return collectionCountDao.selectById(topicid);
    }

    //根据username查询收藏数量信息
    public List<CollectionCount> selectbyusername(String username){
        return collectionCountDao.selectbyusername(username);
    }

    //插入新的收藏问题对象
    public CollectionCount save(CollectionCount collectionCount){
        collectionCountDao.save(collectionCount);
        return collectionCount;
    }

    //更新数据信息
    public int update(CollectionCount collectionCount){
        return collectionCountDao.update(collectionCount);
    }

    //当count为0时删除数据
    public int delete(int topicid,String username){
        return collectionCountDao.delete(topicid,username);
    }
}
