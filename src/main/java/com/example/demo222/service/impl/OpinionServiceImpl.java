package com.example.demo222.service.impl;

import com.example.demo222.dao.OpinionDao;
import com.example.demo222.entity.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl {
    @Autowired
    OpinionDao opinionDao;

    //查找评论中的看客意见
    public List<Opinion> selectOpinion(int topicid,int commentid){
        return opinionDao.selectOpinion(topicid,commentid);
    }

    //添加对用户评论的看法
    public Opinion save(Opinion opinion){
        opinionDao.save(opinion);
        return opinion;
    }

    //删除对用户评论的看法
    //通过topicid和commentid，opinionid删除评论看法
    public int deleteById(int topicid,int commentid,int opinionid) {
        return opinionDao.deleteById(topicid,commentid,opinionid);
    }

    //删除对用户评论的看法
    //通过topicid和commentid，opinionid删除评论看法
    public int deleteById1(int topicid,int commentid) {
        return opinionDao.deleteById1(topicid,commentid);
    }


    //通过username查找用户评论的看法
    public List<Opinion> selectByUsername(String username){
        return opinionDao.selectByUsername(username);
    }
}
