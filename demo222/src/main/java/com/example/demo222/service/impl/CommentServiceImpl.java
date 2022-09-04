package com.example.demo222.service.impl;

import com.example.demo222.dao.CommentDao;
import com.example.demo222.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl{
    @Autowired
    CommentDao commentService;

    public List<Comment> findAll(){
        return commentService.findAll();
    }

    public List<Comment> selectComments(int topic_id){
        return commentService.selectComments(topic_id);
    }
    public Comment save(Comment comment){
        commentService.save(comment);
        return comment;
    }
    public List<Comment> selectbyusername(String username){
        return commentService.selectbyusername(username);
    }

    public int deleteById(int topic_id) {
        return commentService.deleteById(topic_id);
    }
}
