package com.example.demo222.dao;

import com.example.demo222.entity.FansAndStars;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FansAndStarsDao {
    List<FansAndStars> selectbystarname(String starname);

    List<FansAndStars> selectbyfanname(String fanname);

    FansAndStars selectbyname(FansAndStars fansAndStars);

    void insert(FansAndStars fansAndStars);

    int delete(FansAndStars fansAndStars);
}
