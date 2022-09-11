package com.example.demo222.dao;

import com.example.demo222.entity.CollectionCount;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionCountDao {
    CollectionCount selectById(int topicid);

    void save(CollectionCount collectionCount);

    int update(CollectionCount collectionCount);

    List<CollectionCount> selectbyusername(String username);

    int delete(int topicid, String username);
}
