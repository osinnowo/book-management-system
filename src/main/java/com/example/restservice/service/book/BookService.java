package com.example.restservice.service.book;

import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.model.request.BookRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

public interface BookService {
    Flux<BookDto> getAllBooks(String availability);
    Flux<BookCategoryDto> getAllCategories(int limit);
    Mono<BookDto> createBook(BookRequest bookRequest);
    Mono<BookDto> updateBook(Long bookId, BookRequest bookRequest);
}
