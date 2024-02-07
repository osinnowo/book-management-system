package com.example.restservice.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookRequest {
    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed {max} characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 100, message = "Author cannot exceed {max} characters")
    private String author;

    private Long categoryId;

    private Long stockLevel;

    @NotBlank(message = "Availability is required")
    @Pattern(regexp = "(?i)^(AVAILABLE|UNAVAILABLE)$", message = "Invalid availability status")
    private String availability;
}
