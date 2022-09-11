package com.example.demo222.repository;

import com.example.demo222.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface MyRepository extends JpaRepository<Login,Integer>, JpaSpecificationExecutor<Login>{
   //登陆
    @Query(value = "select * from login  where username=?1 and userpassword=?2",nativeQuery = true)
    List<Login> findByUsernameAndUserpassword(String username, String userpassword);

   @Query(value = "select * from login",nativeQuery = true)
   List<Login> findAll();

    //注册
    @Query(value = "select * from login  where username=?1", nativeQuery = true)
    List<Login> findByUsername(String username);
}
