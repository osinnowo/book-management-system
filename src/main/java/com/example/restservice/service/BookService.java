package com.example.restservice.service;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import reactor.core.publisher.Flux;

public interface BookService {

    Flux<BookDto> getAllBooks();
    Flux<BookCategoryDto> getAllCategories(int limit);
}
