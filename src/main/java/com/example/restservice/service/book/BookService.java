package com.example.restservice.service.book;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import reactor.core.publisher.Flux;

public interface BookService {
    Flux<BookDto> getAllBooks(String availability);
    Flux<BookCategoryDto> getAllCategories(int limit);
}
