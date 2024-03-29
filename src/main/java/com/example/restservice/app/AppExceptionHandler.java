package com.example.restservice.app;

import com.example.restservice.exception.*;
import com.example.restservice.model.common.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookCategoryInvalidLimitException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleBatteryLowException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE));
    }

    @ExceptionHandler(BookNotFoundException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleNotFoundException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleBookAlreadyExists(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(BookCategoryNotFoundException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleBookCategoryNotFoundException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_FOUND));
    }

    @Override
    public Mono<ResponseEntity<Object>> handleWebExchangeBindException(WebExchangeBindException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getFieldError().getDefaultMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Override
    public Mono<ResponseEntity<Object>> handleMethodNotAllowedException(MethodNotAllowedException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }
}
