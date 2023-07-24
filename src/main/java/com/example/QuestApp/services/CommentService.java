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

    public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent()&&postId.isPresent()){
            return commentReposi.findByUserIdAndPostId(userId.get(),postId.get());
        }else if (userId.isPresent()){
            return commentReposi.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentReposi.findByPostId(postId.get());
        }else
        return commentReposi.findAll();
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
