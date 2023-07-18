package com.example.QuestApp.mapper.impl;

import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.PostDTOMapperInter;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapperImpl implements PostDTOMapperInter {
    @Override
    public Post dtoTo(PostDTO postDTO, User user) {
        return Post.builder().text(postDTO.getText())
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .user(user).build();

    }
}
