package com.example.restservice.controllers;

import com.example.restservice.model.common.BaseResponse;
import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.model.request.BookRequest;
import com.example.restservice.service.book.BookService;
import com.example.restservice.service.book.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/categories/{categoryId}")
    public Mono<ResponseEntity<BaseResponse<BookCategoryDto>>> getBookCategoryBy(@Validated @PathVariable Long categoryId) {
        return bookService
                .getBookCategoryById(categoryId)
                .map(BaseResponse::okResponse);
    }

    @GetMapping("/categories/{categoryId}/books")
    public Mono<ResponseEntity<BaseResponse<List<BookDto>>>> getBooksByCategory(@Validated @PathVariable Long categoryId) {
        return bookService
                .getBooksByCategory(categoryId)
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

    @PostMapping
    public Mono<ResponseEntity<BaseResponse<BookDto>>> createBook(@Validated @RequestBody BookRequest bookRequest) {
        return bookService
                .createBook(bookRequest)
                .map(BaseResponse::okResponse);
    }

    @PutMapping("/{bookId}")
    public Mono<ResponseEntity<BaseResponse<BookDto>>> updateBook(
            @Validated @PathVariable Long bookId,
            @Validated @RequestBody BookRequest bookRequest
    ) {
        return bookService
                .updateBook(bookId, bookRequest)
                .map(BaseResponse::okResponse);
    }

    @GetMapping("/{bookId}")
    public Mono<ResponseEntity<BaseResponse<BookDto>>> getBookBy(@Validated @PathVariable Long bookId) {
        return bookService
                .getBookById(bookId)
                .map(BaseResponse::okResponse);
    }
}
