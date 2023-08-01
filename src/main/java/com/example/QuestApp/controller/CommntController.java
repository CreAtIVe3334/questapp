package com.example.QuestApp.controller;
import com.example.QuestApp.dto.CommentDTO;
import com.example.QuestApp.dto.CommentUpdateDTO;
import com.example.QuestApp.entity.Comment;
import com.example.QuestApp.services.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommntController {

    @Autowired
    CommentService commentService;

    @GetMapping
    @Transactional
    public ResponseEntity<List<CommentDTO>> allComments(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
        return ResponseEntity.ok().body(commentService.getAllCommentsWithParam(userId,postId));
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody CommentDTO commentDTO){
        return ResponseEntity.ok().body(commentService.createComment(commentDTO));
    }


    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateDTO commentUpdateDTO){
        return ResponseEntity.ok().body(commentService.updateComment(commentId,commentUpdateDTO));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId){
        return ResponseEntity.ok().body(commentService.deleteComment(commentId));
    }

}
