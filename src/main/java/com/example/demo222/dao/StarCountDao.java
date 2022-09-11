package com.example.demo222.dao;

import com.example.demo222.entity.Star;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCountDao {
    Star selectByStarname(String starname);

    void insert(Star star);

    int update(Star star);
}
