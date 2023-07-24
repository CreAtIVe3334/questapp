package com.example.QuestApp.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String title;

    private String text;
}
