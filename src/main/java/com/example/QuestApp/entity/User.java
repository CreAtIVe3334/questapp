package com.example.QuestApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "userss")
public class User {
    @Id

    private Long id;

    @Column(nullable = true)
    private String username;

    @Column(name = "pass")
    private String password;



}
