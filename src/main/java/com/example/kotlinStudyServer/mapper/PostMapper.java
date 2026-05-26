package com.example.kotlinStudyServer.mapper;
import com.example.kotlinStudyServer.model.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface PostMapper {
    List<Post> getListALL();
    List<Post> getOneOfList(String id);
    Post getListCount();
    void uploadPost(Map<String, Object> params);
}
