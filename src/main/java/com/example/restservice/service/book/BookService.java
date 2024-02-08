package com.example.restservice.service.book;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.model.request.BookRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
    Flux<BookCategoryDto> getAllCategories(int limit);
    Mono<BookCategoryDto> getBookCategoryById(Long categoryId);
    Flux<BookDto> getAllBooks(String availability);
    Mono<BookDto> createBook(BookRequest bookRequest);
    Mono<BookDto> updateBook(Long bookId, BookRequest bookRequest);
    Mono<BookDto> getBookById(Long bookId);
    Flux<BookDto> getBooksByCategory(Long categoryId);
}
