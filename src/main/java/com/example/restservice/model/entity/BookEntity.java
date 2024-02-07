package com.example.restservice.model.entity;

import com.example.restservice.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "books")
public class BookEntity extends BaseEntity<BookEntity> {
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Long stockLevel;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookAvailabilityEntity availability;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategoryEntity category;
}

