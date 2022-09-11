package com.example.demo222.dao;

import com.example.demo222.entity.Fan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FanCountDao {
    Fan selectByFanname(String fanname);

    void insert(Fan fan);

    int update(Fan fan);
}
