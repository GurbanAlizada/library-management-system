package com.example.librarysystem.dto.request;

import java.util.List;

public record AddDetailRequest(
        String title,
        String descripton,
        List<Long> aurhorIDs,
        List<Long> categoryIDs

) {

}
