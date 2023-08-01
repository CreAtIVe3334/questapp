package com.example.QuestApp.mapper.impl;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.entity.Like;
import com.example.QuestApp.mapper.inter.LikeDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class LikeDTOMapperImpl implements LikeDTOMapper {


    @Override
    public LikeDTO entityTo(Like like) {
        return LikeDTO.builder().id(like.getId())
                .postId(like.getPost().getId())
                .userId(like.getUser().getId())
                .build();
    }


}
