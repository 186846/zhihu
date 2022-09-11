package com.example.demo222.dao;

import com.example.demo222.entity.Opinion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionDao {
    List<Opinion> selectOpinion(int topicid, int commentid);

    void save(Opinion opinion);

    int deleteById(int topicid, int commentid, int opinionid);

    List<Opinion> selectByUsername(String username);

    int deleteById1(int topicid, int commentid);
}
