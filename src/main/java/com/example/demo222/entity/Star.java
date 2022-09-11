package com.example.demo222.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Star {
    private String starname;
    //相当于starname的粉丝个数
    private Integer count;
}
