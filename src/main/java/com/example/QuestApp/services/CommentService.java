package com.example.QuestApp.services;

import com.example.QuestApp.dto.CommentDTO;
import com.example.QuestApp.dto.CommentUpdateDTO;
import com.example.QuestApp.entity.Comment;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.CommentDTOMapper;
import com.example.QuestApp.repository.CommentReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    CommentReposi commentReposi;

    @Autowired
    CommentDTOMapper commentDTOMapper;

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    public List<CommentDTO> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> list;

        if(userId.isPresent()&&postId.isPresent()){
            list = commentReposi.findByUserIdAndPostId(userId.get(),postId.get());
            return list.stream().map(f -> commentDTOMapper.entityTo(f)).collect(Collectors.toList());
        }else if (userId.isPresent()){
            list = commentReposi.findByUserId(userId.get());
            return list.stream().map(f -> commentDTOMapper.entityTo(f)).collect(Collectors.toList());
        } else if (postId.isPresent()) {
            list = commentReposi.findByPostId(postId.get());
            return list.stream().map(f -> commentDTOMapper.entityTo(f)).collect(Collectors.toList());
        }else
            list = commentReposi.findAll();
        return list.stream().map(f -> commentDTOMapper.entityTo(f)).collect(Collectors.toList());
    }

    public Comment createComment(CommentDTO commentDTO) {
        Post post=postService.getPost(commentDTO.getPostId());
        User user=userService.findUser(commentDTO.getUserId());
        Comment comment = commentDTOMapper.dtoTo(commentDTO,user,post);
        return commentReposi.save(comment);
    }


    public Comment updateComment(Long commentId, CommentUpdateDTO commentUpdateDTO) {
        Comment comment = commentReposi.findById(commentId).orElse(null);
        comment.setText(commentUpdateDTO.getText());
        return commentReposi.save(comment);

    }

    public String deleteComment(Long commentId) {
        commentReposi.deleteById(commentId);
        return "Succesfuly deleted";
    }
}
