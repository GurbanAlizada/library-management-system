package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Detail;

public record PopularBooksDto(
        DetailDto detailDto,
        Long count

) {


    public static PopularBooksDto convert(Detail detail, Long count){
        return new PopularBooksDto(
                DetailDto.convert(detail),
                count
        );
    }

}
