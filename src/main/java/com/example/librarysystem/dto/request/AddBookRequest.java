package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddBookRequest(

        @NotBlank
        String isbn,
        @NotBlank
        String titleId,
        @NotNull
        Integer unitsInStock,
        List<String> publisherIDs,
        List<String> aurhorIDs,
        List<String> categoryIDs

) {
}
