package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Category;
import com.example.librarysystem.model.Detail;

import java.util.List;
import java.util.stream.Collectors;

public record DetailDto(
        Long id,
        String title,
        String description,
        Integer unitsInStock,
        List<AuthorDto> authorDtos,
        List<CategoryDto> categoryDtos
) {
    public static DetailDto convert(Detail from) {
        return new DetailDto(
                from.getId(),
                from.getTitle(),
                from.getDescription(),
                from.getUnitsInStock(),
                from.getAuthors().stream().map(AuthorDto::convert).collect(Collectors.toList()),
                from.getCategories().stream().map(CategoryDto::convert).collect(Collectors.toList())
        );
    }
}

