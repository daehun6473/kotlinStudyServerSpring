package com.example.kotlinStudyServer.controller;

import com.example.kotlinStudyServer.model.Post;
import com.example.kotlinStudyServer.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/list")
    public ResponseEntity<List<Post>> getList(
            @RequestParam String id
    ) {
        List<Post> postList = service.getList(id);
        return ResponseEntity.ok(postList);
    }

}
