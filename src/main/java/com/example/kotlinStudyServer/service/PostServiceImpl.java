package com.example.kotlinStudyServer.service;

import com.example.kotlinStudyServer.mapper.PostMapper;
import com.example.kotlinStudyServer.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper mapper;

    @Override
    public List<Post> getList(String id) {
        List<Post> result;
        if("ALL".equals(id) || id.isEmpty() || id.isBlank()){
            result = mapper.getListALL();
        }else {
            result = mapper.getOneOfList(id);
        }

        Post countPost = mapper.getListCount();
        for(Post post : result){
            post.setMaxCount(countPost.getMaxCount());
        }
        return result;
    }

    @Override
    public List<Post> upsertList(Map<String, Object> params) {

        String userId = (String) params.get("userId");
        String title = (String) params.get("title");
        String body = (String) params.get("body");

        Map<String, Object> insertParams = new HashMap<>();
        insertParams.put("userId", userId);
        insertParams.put("title", title);
        insertParams.put("body", body);

        mapper.uploadPost(insertParams);
        List<Post> postResult = mapper.getListALL();
        return postResult;
    }


}
