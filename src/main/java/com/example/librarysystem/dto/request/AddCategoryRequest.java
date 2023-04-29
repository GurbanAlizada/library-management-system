package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddCategoryRequest(
        @NotBlank
        String categoryName

) {


}