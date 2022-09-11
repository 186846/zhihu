package com.example.demo222.dao;

import com.example.demo222.entity.CollectionPerson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionPersonDao {


    List<CollectionPerson> selectbyusername(String username);

    CollectionPerson selectById(int topicid, String username);

    void insert(CollectionPerson collectionPerson);

    int delete(CollectionPerson collectionPerson);
}
