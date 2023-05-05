package com.example.librarysystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AddBookRequest(

        // TODO write custom valid annotation
        @NotBlank
        String isbn,
        @NotNull
        Long detailId,
        @NotNull
        Long publisherId


) {

}
