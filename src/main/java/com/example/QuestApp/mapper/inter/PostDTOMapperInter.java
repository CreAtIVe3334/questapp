package com.example.QuestApp.mapper.inter;

import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface PostDTOMapperInter {

    public Post dtoTo(PostDTO postDTO, User user);

}