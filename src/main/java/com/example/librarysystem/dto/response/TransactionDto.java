package com.example.librarysystem.dto.response;

import com.example.librarysystem.model.Transaction;

import java.time.LocalDateTime;

public record TransactionDto(

        Long transactionId,
        BookDto bookDto,
        Long userId,
        Boolean IsReturned,
        LocalDateTime issueDate,
        LocalDateTime dueDate,
        LocalDateTime returnDate

) {

    public static TransactionDto convert(Transaction from){
        return new TransactionDto(
                from.getId(),
                BookDto.convert(from.getBook()),
                from.getUser().getId(),
                from.getReturned(),
                from.getIssueDate(),
                from.getDueDate(),
                from.getReturnDate()
        );
    }

}
