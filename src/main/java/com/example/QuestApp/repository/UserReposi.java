package com.example.QuestApp.repository;

import com.example.QuestApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReposi extends JpaRepository<User,Long> {
    public List<User> findAll();

}
