package com.example.restservice.model.mapper;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.entity.BookCategoryEntity;

public class BookMapper {
    public static BookCategoryDto fromEntity(BookCategoryEntity entity) {
        return BookCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }
}
