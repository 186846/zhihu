package com.example.demo222.dao;

import com.example.demo222.entity.LikePerson;
import org.springframework.stereotype.Service;

@Service
public interface LikePersonDao {
    LikePerson selectById(int topicid, int commentid, String username);

    void insert(LikePerson likePerson);

    int delete(LikePerson likePerson);
}
