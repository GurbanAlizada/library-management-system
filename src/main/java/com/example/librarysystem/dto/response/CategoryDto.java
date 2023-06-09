package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Category;

public record CategoryDto(

        Long id,
        String categoryName

) {

    public static CategoryDto convert(Category from){
        return new CategoryDto(from.getId() , from.getCategoryName());
    }

}
