package com.example.QuestApp.services;

import com.example.QuestApp.entity.User;
import com.example.QuestApp.enums.Role;
import com.example.QuestApp.repository.UserReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    UserReposi userReposi;

    public List<User> getAllUsers(){
        return userReposi.findAll();
    }

    public User saveOnUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userReposi.save(user);
    }

    public User findUser(Long id){
        return userReposi.findById(id).orElse(null);
    }

    public User findUserName(String user){
        return userReposi.findByUsername(user);
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
