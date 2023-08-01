package com.example.QuestApp.mapper.inter;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.dto.PostsDTO;
import com.example.QuestApp.entity.Like;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PostDTOMapper {

    public Post dtoTo(PostDTO postDTO, User user);
    public PostsDTO entityTo(Post post, List<LikeDTO> likeList);
}
