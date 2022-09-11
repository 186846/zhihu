package com.example.demo222.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opinion {
    private Integer topicid;
    private Integer commentid;
    private Integer opinionid;
    private String username;
    private String opinion;
}
