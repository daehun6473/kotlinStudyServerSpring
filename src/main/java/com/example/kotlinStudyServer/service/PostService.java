package com.example.kotlinStudyServer.service;

import com.example.kotlinStudyServer.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getList(String id);
//    void getListCount();
}
