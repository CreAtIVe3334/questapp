package com.example.QuestApp.services;

import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.PostDTOMapperInter;
import com.example.QuestApp.repository.PostReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostReposi postReposi;

    @Autowired
    UserService userService;

    @Autowired
   PostDTOMapperInter postDTOMapperInter;

    public List<Post> getAllPosts(Optional<Long> userId){
        if(userId.isPresent())
            return postReposi.findByUserId(userId.get());
        return postReposi.findAll();
    }

    public Post getPost(Long postId) {
        return postReposi.findById(postId).orElse(null);
    }

    public Post create(PostDTO postDTO){
        User user = userService.findUser(postDTO.getUserId());
        if(user==null)
            return null;
        Post post = postDTOMapperInter.dtoTo(postDTO,user);
        return postReposi.save(post);
    }

    public Post updateOnePost(Long postId,Post post)
    {
        Post post1 = postReposi.findById(postId).get();
        post1.setText(post.getText());
        post1.setTitle(post.getTitle());
        return postReposi.save(post1);
    }

    public String deleteOnePost(Long postId) {
        postReposi.deleteById(postId);
        return "Succesfully deleted";
    }
}
