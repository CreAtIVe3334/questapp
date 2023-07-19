package com.example.QuestApp.services;

import com.example.QuestApp.entity.User;
import com.example.QuestApp.repository.UserReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserReposi userReposi;

    public List<User> getAllUsers(){
        return userReposi.findAll();
    }

    public User saveOnUser(User user){
        return userReposi.save(user);
    }

    public User findUser(Long id){
        return userReposi.findById(id).orElse(null);
    }

    public String deleteUser(Long userId){
        userReposi.deleteById(userId);
        return "Succesfully deleted";
    }

    public User updateUser(Long userId, User user) {
        User user1 = userReposi.findById(userId).orElse(null);
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return userReposi.save(user1);
    }
}
