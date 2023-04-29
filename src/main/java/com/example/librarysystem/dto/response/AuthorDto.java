package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Author;

public record AuthorDto (
        String id,
        String author
){

    public static AuthorDto convert(Author from){
        return new AuthorDto(from.getId() , from.getAuthor());
    }

}
