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

    //查找所有评论
    //没有用到
    public List<Comment> findAll(){
        return commentService.findAll();
    }

    //按照topicid查找评论
    //相当于点击查看评论的按钮
    public List<Comment> selectComments(int topicid){
        return commentService.selectComments(topicid);
    }
    //通过topicid和commentid查找评论
    public Comment selectbyid(int topicid,int commentid){
        return commentService.selectbyid(topicid,commentid);
    }

    //添加评论
    public Comment save(Comment comment){
        commentService.save(comment);
        return comment;
    }
    //通过用户名查找评论
    //在”我的“界面显示
    public List<Comment> selectbyusername(String username){
        return commentService.selectbyusername(username);
    }

    //通过topicid和commentid删除评论
    public int deleteById(int topicid,int commentid) {
        return commentService.deleteById(topicid,commentid);
    }

    //通过topicid删除评论
    public void deleteById1(int topicid) {
        commentService.deleteById1(topicid);
    }
}
