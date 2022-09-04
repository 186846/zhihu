package com.example.demo222.dao;

import com.example.demo222.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao {
    List<Question> findAll();
    void save (Question question);

    List<Question> selectbyusername(String username);

    int deleteById(int topic_id);

    Question selectById(int topic_id);
}
