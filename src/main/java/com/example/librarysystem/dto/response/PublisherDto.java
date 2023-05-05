package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Publisher;

public record PublisherDto(
        Long id,
        String publisher

) {
    public static PublisherDto convert(Publisher from){
        return new PublisherDto(from.getId(), from.getPublisher());
    }

}
