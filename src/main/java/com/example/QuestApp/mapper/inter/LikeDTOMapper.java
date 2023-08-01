package com.example.QuestApp.mapper.inter;

import com.example.QuestApp.dto.LikeDTO;
import com.example.QuestApp.entity.Like;
import org.mapstruct.Mapper;

@Mapper
public interface LikeDTOMapper {
    public LikeDTO entityTo(Like like);


}
