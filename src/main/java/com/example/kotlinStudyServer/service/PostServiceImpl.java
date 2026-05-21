package com.example.kotlinStudyServer.service;

import com.example.kotlinStudyServer.mapper.PostMapper;
import com.example.kotlinStudyServer.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
