package com.example.demo222.service.impl;

import com.example.demo222.dao.LikeCountDao;
import com.example.demo222.entity.LikeCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeCountServiceImpl {
    @Autowired
    LikeCountDao likeCountDao;

    //根据topicid查询点赞数量信息
    public LikeCount selectById(int topicid,int commentid){
        return likeCountDao.selectById(topicid,commentid);
    }
    //根据username查询点赞数量信息
    public List<LikeCount> selectbyusername(String username){
        return likeCountDao.selectbyusername(username);
    }
    //根据topicid查询点赞数量信息
    public List<LikeCount> selectbytopicid(int topicid){
        return likeCountDao.selectbytopicid(topicid);
    }
    //插入新的评论点赞对象
    public LikeCount save(LikeCount likeCount){
        likeCountDao.save(likeCount);
        return likeCount;
    }
    //更新数据信息
    public int update(LikeCount likeCount){
        return likeCountDao.update(likeCount);
    }
    //当count为0时，删除该条数据
    public int delete(int topicid,int commentid){
        return likeCountDao.delete(topicid,commentid);
    }
}
