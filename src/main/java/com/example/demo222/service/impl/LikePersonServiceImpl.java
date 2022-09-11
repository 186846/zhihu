package com.example.demo222.service.impl;

import com.example.demo222.dao.LikePersonDao;
import com.example.demo222.entity.LikePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePersonServiceImpl {
    @Autowired
    LikePersonDao likepersonDao;

    //通过topicid，username查询收藏用户信息
    public LikePerson selectById(int topicid,int commentid, String username){
        return likepersonDao.selectById(topicid,commentid,username);
    }

    //添加用户点赞信息
    public LikePerson insert(LikePerson likePerson){
        likepersonDao.insert(likePerson);
        return likePerson;
    }
    //删除用户点赞信息
    public int delete(LikePerson likePerson) {
        return likepersonDao.delete(likePerson);
    }
}
