package com.example.QuestApp.services;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.entity.Like;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.LikeDTOMapper;
import com.example.QuestApp.repository.LikeRepository;
import com.example.QuestApp.repository.PostReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    UserService userService;


    @Autowired
    PostReposi postReposi;


    @Autowired
    LikeDTOMapper likeDTOMapper;


    public Like saveLike(LikeDTO likeDTO){
        User user = userService.findUser(likeDTO.getUserId());
        Post post = postReposi.findById(likeDTO.getPostId()).orElse(null);
        return Like.builder()
                .post(post)
                .user(user)
                .build();
    }

//    public String deleteLike(Long userId,Long postId){
//        Like like = likeRepository.findByUserIdAndPostId(userId,postId);
//        likeRepository.delete(like);
//        return "Succesfully deleted";
//    }


    public List<LikeDTO> getAllLikesWithParams(Optional<Long> userId, Optional<Long> postId){
        List<Like> likes;
        if(userId.isPresent()&& postId.isPresent()){
            likes = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
            return likes.stream().map(p->likeDTOMapper.entityTo(p)).collect(Collectors.toList());
        }else if (userId.isPresent()){
            likes = likeRepository.findByUserId(userId.get());
            return likes.stream().map(p->likeDTOMapper.entityTo(p)).collect(Collectors.toList());
        } else if (postId.isPresent()) {
            likes = likeRepository.findByPostId(postId.get());
            return likes.stream().map(p->likeDTOMapper.entityTo(p)).collect(Collectors.toList());
        }
        likes = likeRepository.findAll();
        return likes.stream().map(p->likeDTOMapper.entityTo(p)).collect(Collectors.toList());
    }

}
