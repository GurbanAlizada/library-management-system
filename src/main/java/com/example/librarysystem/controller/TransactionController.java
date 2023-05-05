package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddTransactionRequest;
import com.example.librarysystem.dto.response.PopularAuthorsDto;
import com.example.librarysystem.dto.response.TransactionDateDto;
import com.example.librarysystem.dto.response.TransactionDto;
import com.example.librarysystem.service.TransactionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/v1/api/transaction")
@Validated
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity<Void> addTransaction(@RequestBody @Valid AddTransactionRequest request){
        transactionService.addTransaction(request);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> changeStatus(@RequestParam @NotBlank String isbn){
        transactionService.changeStatus( isbn);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/issue/date")
    public ResponseEntity<TransactionDateDto> findByIssueDateCount
            (@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok( transactionService.findByIssueDateIsReturnFalseCount(date));
    }





    @GetMapping("/return/date")
    public ResponseEntity<TransactionDateDto> findByReturnDateCount
            (@RequestParam("date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return ResponseEntity.ok( transactionService.findByReturnDateIsReturnTrueCount(date));
    }




    @GetMapping("/popular/authors")
    public ResponseEntity<List<PopularAuthorsDto>> getMostPopularAuthorsAndCount(){
        return ResponseEntity.ok(transactionService.getMostPopularAuthorsAndCount());
    }



    @GetMapping("/finCode/{finCode}")
    public ResponseEntity<List<TransactionDto>> getByUser_FinCode
            (@PathVariable @NotBlank String finCode){
        return ResponseEntity.ok(transactionService.getByUser_FinCode(finCode));
    }





    


}
