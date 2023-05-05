package com.example.librarysystem.dto.response;

import java.util.List;

public record TransactionDateDto(
        List<TransactionDto> transactionDtoList,
        Integer count

) {

    public static TransactionDateDto convert(List<TransactionDto> transactionDtoList ){
        return new TransactionDateDto(
                transactionDtoList,
                transactionDtoList.size()
        );
    }

}
