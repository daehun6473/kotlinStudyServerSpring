package com.example.kotlinStudyServer.model;

import lombok.Data;

@Data
public class Post {
    private String id;
    private String userId;
    private String title;
    private String body;
    private String createdAt;
    private String maxCount;
}
