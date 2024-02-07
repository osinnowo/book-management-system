package com.example.restservice.controllers;

import com.example.restservice.model.common.BaseResponse;
import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.service.book.BookService;
import com.example.restservice.service.book.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/categories")
    public Mono<ResponseEntity<BaseResponse<List<BookCategoryDto>>>> getBookCategories(@RequestParam(required = false, defaultValue = "10") Integer limit) {
        return bookService.getAllCategories(limit)
                .collectList()
                .map(BaseResponse::okResponse);
    }

    @GetMapping
    public Mono<ResponseEntity<BaseResponse<List<BookDto>>>> getAllBooks() {
        return bookService.getAllBooks(BookServiceImpl.BooksQueryEnum.ALL.name())
                .collectList()
                .map(BaseResponse::okResponse);
    }

    @GetMapping("/status")
    public Mono<ResponseEntity<BaseResponse<List<BookDto>>>> getBooks(@RequestParam(required = true) String availability) {
        return bookService.getAllBooks(availability)
                .collectList()
                .map(BaseResponse::okResponse);
    }
}
