package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddPublisherRequest(
        @NotBlank
        String publisher
) {
}
