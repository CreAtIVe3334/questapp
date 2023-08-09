package com.example.QuestApp.repository;

import com.example.QuestApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserReposi extends JpaRepository<User,Long> {
    public List<User> findAll();

    User findByUsername(String user);
}
