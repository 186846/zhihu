package com.example.demo222.dao;

import com.example.demo222.entity.LikeCount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeCountDao {
    LikeCount selectById(int topicid, int commentid);

    List<LikeCount> selectbyusername(String username);

    void save(LikeCount likeCount);

    List<LikeCount> selectbytopicid(int topicid);

    int update(LikeCount likeCount);

    int delete(int topicid, int commentid);
}
