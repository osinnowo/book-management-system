package com.example.restservice.service.book;

import com.example.restservice.app.AppMessage;
import com.example.restservice.exception.BookCategoryInvalidLimitException;
import com.example.restservice.model.dto.BookCategoryDto;
import com.example.restservice.model.dto.BookDto;
import com.example.restservice.model.entity.BookAvailabilityEntity;
import com.example.restservice.model.entity.BookEntity;
import com.example.restservice.model.mapper.BookMapper;
import com.example.restservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Pageable;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    public enum BooksQueryEnum {
        ALL,
        AVAILABLE,
        UNAVAILABLE
    }

    private final BookRepository repository;

    @Override
    public Flux<BookDto> getAllBooks(String availability) {
        List<BookEntity> books;
        BooksQueryEnum type = BooksQueryEnum.valueOf(availability);
        switch (type) {
            case ALL -> books = repository.queryAllBooks();
            default ->  books = repository.queryAllBooksByAvailability(BookAvailabilityEntity.valueOf(type.name()));
        }

        return Flux.fromIterable(
                books
                .stream()
                .map(BookMapper::fromEntity)
                .collect(Collectors.toList())
        );
    }

    @Override
    public Flux<BookCategoryDto> getAllCategories(int limit) {
        if (limit < 1) {
            throw new BookCategoryInvalidLimitException(AppMessage.LIMIT_CANNOT_BE_LESS_THAN_ONE);
        }

        return Flux.fromIterable(
                repository.getBookCategoriesWithLimit(Pageable.ofSize(limit))
                        .stream()
                        .map(BookMapper::fromEntity)
                        .collect(Collectors.toList())
                );
    }
}