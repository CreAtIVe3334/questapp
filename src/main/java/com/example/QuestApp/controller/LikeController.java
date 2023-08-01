package com.example.QuestApp.controller;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.entity.Like;
import com.example.QuestApp.services.LikeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> saveLike(LikeDTO likeDTO){
        return ResponseEntity.ok().body(likeService.saveLike(likeDTO));
    }

//    @DeleteMapping
//    ResponseEntity<String> deleteLike(Long userId,Long postId){
//        return ResponseEntity.ok().body(likeService.deleteLike(userId,postId));
//    }

}
