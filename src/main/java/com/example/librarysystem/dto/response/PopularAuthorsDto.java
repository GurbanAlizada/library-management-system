package com.example.librarysystem.dto.response;

public record PopularAuthorsDto(
        String author,
        Integer count

) {
    public PopularAuthorsDto(String author, Integer count) {
        this.author=author;
        this.count=count;
    }
}
