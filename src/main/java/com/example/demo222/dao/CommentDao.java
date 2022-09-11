package com.example.demo222.dao;

import com.example.demo222.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    List<Comment> findAll();

    List<Comment> selectComments(int topicid);

    void save(Comment comment);

    List<Comment> selectbyusername(String username);

    int deleteById(int topicid,int commentid);

    void deleteById1(int topicid);

     Comment selectbyid(int topicid, int commentid);
}
