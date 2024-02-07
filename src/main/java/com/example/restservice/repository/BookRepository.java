package com.example.restservice.repository;

import com.example.restservice.model.entity.BookCategoryEntity;
import com.example.restservice.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT b FROM BookEntity b WHERE b.isSoftDeleted = false AND b.availability = 'AVAILABLE'")
    List<BookEntity> queryAvailableBooks();

    @Query("SELECT c FROM BookCategoryEntity c WHERE c.isSoftDeleted = false")
    List<BookCategoryEntity> getBookCategoriesWithLimit(Pageable pageable);

    BookEntity findBookByCategoryId(Long categoryId);
}