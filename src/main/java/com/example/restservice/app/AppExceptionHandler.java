package com.example.restservice.app;

import com.example.restservice.exception.*;
import com.example.restservice.model.common.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookCategoryInvalidLimitException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleBatteryLowException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.NOT_ACCEPTABLE));
    }
}
