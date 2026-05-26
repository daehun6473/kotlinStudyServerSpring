package com.example.kotlinStudyServer.controller;

import com.example.kotlinStudyServer.model.Post;
import com.example.kotlinStudyServer.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
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

    @PostMapping("/upsertList")
    public ResponseEntity<List<Post>> upsertList(
            @RequestBody Post post
    ){
        try{
            Map<String, Object> params = new HashMap<>();

            params.put("userId", post.getUserId());
            params.put("title", post.getTitle());
            params.put("body", post.getBody());

            List<Post> result = service.upsertList(params);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(result);

        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }
    //    @PostMapping("/deleteList/{num}/{regId}")
//    public ResponseEntity<List<Board>> deleteList(
//            @PathVariable String num,
//            @PathVariable String regId
//    ){
//        Map<String, Object> params = new HashMap<>();
//        params.put("num",num);
//        params.put("regId",regId);
//
//        List<Board> deleteResult = service.deleteList(params);
//        return ResponseEntity.ok(deleteResult);
//    }
}
