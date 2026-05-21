package com.example.kotlinStudyServer.mapper;
import com.example.kotlinStudyServer.model.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> getListALL();
    List<Post> getOneOfList(String id);
    Post getListCount();
}
