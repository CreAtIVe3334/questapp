package com.example.QuestApp.mapper.impl;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.dto.PostsDTO;
import com.example.QuestApp.entity.Like;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.PostDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDTOMapperImpl implements PostDTOMapper {
    @Override
    public Post dtoTo(PostDTO postDTO, User user) {
        return Post.builder().text(postDTO.getText())
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .user(user).build();
    }

    @Override
    public PostsDTO entityTo(Post post, List<LikeDTO> likeList) {
        return PostsDTO.builder()
                .id(post.getId())
                .userId(post.getUser().getId())
                .userName(post.getUser().getUsername())
                .text(post.getText())
                .title(post.getTitle())
                .likes(likeList)
                .build();
    }


}
