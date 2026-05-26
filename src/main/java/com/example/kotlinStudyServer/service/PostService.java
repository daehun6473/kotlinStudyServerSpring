package com.example.kotlinStudyServer.service;

import com.example.kotlinStudyServer.model.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<Post> getList(String id);
//    void getListCount();
    List<Post> upsertList(Map<String, Object> params);
}
