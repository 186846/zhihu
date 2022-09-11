package com.example.demo222.service.impl;

import com.example.demo222.dao.QuestionDao;
import com.example.demo222.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl{
    @Autowired
    private QuestionDao questionDao;

    public List<Question> findAll() {
        return questionDao.findAll();
    }

    public Question save(Question question){
        questionDao.save(question);
        return question;
    }

    public List<Question> selectbyusername(String username){
       return questionDao.selectbyusername(username);
    }

    public int deleteById(int topicid) {
        return questionDao.deleteById(topicid);
    }

    public Question selectById(int topicid){
        return questionDao.selectById(topicid);
    }
}
