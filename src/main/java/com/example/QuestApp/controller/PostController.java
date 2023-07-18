package com.example.QuestApp.controller;

import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam Optional<Long> userId){
        return ResponseEntity.ok().body(postService.getAllPosts(userId));
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody PostDTO post){
        return ResponseEntity.ok().body(postService.create(post));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getOnePost(@PathVariable Long postId){
        return ResponseEntity.ok().body(postService.getPost(postId));
    }
}