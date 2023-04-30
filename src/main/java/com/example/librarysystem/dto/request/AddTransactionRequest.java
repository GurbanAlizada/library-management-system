package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddTransactionRequest(
        @NotBlank
        String isbn,
        @NotBlank
        String finCode,
        @NotNull
        long days

) {
}
