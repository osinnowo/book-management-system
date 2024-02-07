package com.example.restservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookCategoryNotFoundException extends RuntimeException {
    public BookCategoryNotFoundException(String message) {
        super(message);
    }
}
