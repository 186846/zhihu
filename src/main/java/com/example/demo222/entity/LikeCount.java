package com.example.demo222.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCount {
    private Integer topicid;
    private Integer commentid;
    private String username;
    private Integer count;
}
