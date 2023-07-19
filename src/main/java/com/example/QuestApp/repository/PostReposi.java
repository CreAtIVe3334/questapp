package com.example.QuestApp.repository;

import com.example.QuestApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostReposi extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
}
