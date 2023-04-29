package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Title;

public record TitleDto(
        String id,
        String title

) {
    public static TitleDto convert(Title from){
        return new TitleDto(from.getId(), from.getTitle());
    }
}
