package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddAuthorRequest(
        @NotBlank
        String author
){


}
