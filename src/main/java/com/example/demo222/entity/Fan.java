package com.example.demo222.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fan {
    private String fanname;
    //相当于fanname的偶像数目
    private Integer count;
}
