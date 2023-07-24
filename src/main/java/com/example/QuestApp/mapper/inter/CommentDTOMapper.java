package com.example.QuestApp.mapper.inter;

import com.example.QuestApp.dto.CommentDTO;
import com.example.QuestApp.entity.Comment;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface CommentDTOMapper {
    public Comment dtoTo(CommentDTO commentDTO, User user, Post post);


}
