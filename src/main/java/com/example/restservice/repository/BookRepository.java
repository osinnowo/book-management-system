package com.example.restservice.repository;

import com.example.restservice.model.entity.BookAvailabilityEntity;
import com.example.restservice.model.entity.BookCategoryEntity;
import com.example.restservice.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Query("SELECT b FROM BookEntity b WHERE b.isSoftDeleted = false")
    List<BookEntity> queryAllBooks();

    @Query("SELECT b FROM BookEntity b WHERE b.isSoftDeleted = false AND b.availability = :availability")
    List<BookEntity> queryAllBooksByAvailability(@Param("availability") BookAvailabilityEntity availability);

    Optional<BookEntity> findBookByTitle(String title);

    @Query("SELECT c FROM BookCategoryEntity c WHERE c.isSoftDeleted = false")
    List<BookCategoryEntity> getBookCategoriesWithLimit(Pageable pageable);

    Optional<BookEntity> findBookByCategoryId(Long categoryId);

    @Query("SELECT c FROM BookCategoryEntity c WHERE c.isSoftDeleted = false AND c.id = :categoryId")
    Optional<BookCategoryEntity> getBookCategoryById(Long categoryId);
}