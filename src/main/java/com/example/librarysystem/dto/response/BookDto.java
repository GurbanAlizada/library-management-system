package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Book;

import java.util.List;
import java.util.stream.Collectors;

public record BookDto(

        String id,
        String isbn,
        String title,
        List<PublisherDto> publishers,
        List<AuthorDto> authors,
        List<CategoryDto> categories

) {
    public static BookDto convert(Book from){
        return new BookDto(
                from.getId(),
                from.getIsbn(),
                from.getTitle().getTitle(),
                from.getPublishers().stream().map(n->PublisherDto.convert(n)).collect(Collectors.toList()),
                from.getAuthors().stream().map(AuthorDto::convert).collect(Collectors.toList()),
                from.getCategories().stream().map(n->CategoryDto.convert(n)).collect(Collectors.toList())
        );
    }


}
