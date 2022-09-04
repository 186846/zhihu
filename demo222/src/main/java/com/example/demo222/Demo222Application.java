package com.example.demo222;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo222.dao")
public class Demo222Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo222Application.class, args);
    }
}