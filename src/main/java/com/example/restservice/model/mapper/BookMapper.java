package com.example.restservice.model.mapper;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.model.entity.BookCategoryEntity;
import com.example.restservice.model.entity.BookEntity;

public class BookMapper {
    public static BookCategoryDto fromEntity(BookCategoryEntity entity) {
        return BookCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }

    public static BookDto fromEntity(BookEntity entity) {
        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .stockLevel(entity.getStockLevel())
                .availability(entity.getAvailability().name())
                .category(entity.getCategory().getName())
                .build();
    }
}
