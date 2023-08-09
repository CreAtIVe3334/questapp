package com.example.QuestApp.repository;

import com.example.QuestApp.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {

    List<Like> findAllByUserIdAndPostId(Long userId, Long postId);

    Like findByUserIdAndPostId(Long userId, Long postId);

    List<Like> findByPostId(Long postId);

    List<Like> findByUserId(Long userId);
}
