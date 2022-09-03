package com.zhihu.zhihuapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhihu.zhihuapp.dao")
public class ZhihuappApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZhihuappApplication.class, args);
    }
}
