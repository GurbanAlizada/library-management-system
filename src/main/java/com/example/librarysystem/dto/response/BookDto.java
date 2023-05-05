package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Book;

public record BookDto(

        Long id,
        String isbn,
        DetailDto detailDto,
        PublisherDto publisherDto


) {
    public static BookDto convert(Book from){
        return new BookDto(
                from.getId(),
                from.getIsbn(),
                DetailDto.convert(from.getDetail()),
                PublisherDto.convert(from.getPublisher())
                );
    }


}
