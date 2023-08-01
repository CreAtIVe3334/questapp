package com.example.QuestApp.mapper.impl;

import com.example.QuestApp.dto.CommentDTO;
import com.example.QuestApp.entity.Comment;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.CommentDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentDTOMapperImpl implements CommentDTOMapper {



    @Override
    public Comment dtoTo(CommentDTO commentDTO, User user, Post post) {

        return Comment.builder().id(commentDTO.getId()).text(commentDTO.getText()).post(post).user(user).build();
    }

    @Override
    public CommentDTO entityTo(Comment comment) {
        return CommentDTO.builder().id(comment.getId())
                .postId(comment.getPost().getId())
                .userId(comment.getUser().getId())
                .text(comment.getText()).build();
    }
}
