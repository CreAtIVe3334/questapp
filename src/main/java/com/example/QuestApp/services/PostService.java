package com.example.QuestApp.services;

import com.example.QuestApp.dto.PostDTO;
import com.example.QuestApp.dto.PostsDTO;
import com.example.QuestApp.entity.Post;
import com.example.QuestApp.entity.User;
import com.example.QuestApp.mapper.inter.PostDTOMapper;
import com.example.QuestApp.repository.PostReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostReposi postReposi;

    @Autowired
    UserService userService;

    @Autowired
    PostDTOMapper postDTOMapper;



    public List<PostsDTO> getAllPosts(Optional<Long> userId){
        List<Post> list;
        if(userId.isPresent())
            list = postReposi.findByUserId(userId.get());
        list = postReposi.findAll();
        return  list.stream().map(p->postDTOMapper.entityTo(p)).collect(Collectors.toList());
        
    }

    public Post getPost(Long postId) {
        return postReposi.findById(postId).orElse(null);
    }

    public Post create(PostDTO postDTO){
        User user = userService.findUser(postDTO.getUserId());
        if(user==null)
            return null;
        Post post = postDTOMapper.dtoTo(postDTO,user);
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
