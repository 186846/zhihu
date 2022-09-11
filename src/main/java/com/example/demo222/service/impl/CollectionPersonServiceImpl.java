package com.example.demo222.service.impl;

import com.example.demo222.dao.CollectionPersonDao;
import com.example.demo222.entity.CollectionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionPersonServiceImpl {
    @Autowired
    CollectionPersonDao collectionPersonDao;

    //通过topicid，username查询收藏用户信息
    public CollectionPerson selectById(int topicid,String username){
        return collectionPersonDao.selectById(topicid,username);
    }
    //通过username查询收藏用户的信息
    public List<CollectionPerson> selectbyusername(String username){
        return collectionPersonDao.selectbyusername(username);
    }

    //添加用户收藏
    public CollectionPerson insert(CollectionPerson collectionPerson){
        collectionPersonDao.insert(collectionPerson);
        return collectionPerson;
    }
    //喊出用户收藏
    public int delete(CollectionPerson collectionPerson) {
        return collectionPersonDao.delete(collectionPerson);
    }
}
