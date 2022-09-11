package com.example.demo222.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionCount {
    private Integer topicid;
    private String username;
    private Integer count;
}
