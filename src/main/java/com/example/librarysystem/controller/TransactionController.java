package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddTransactionRequest;
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
    public ResponseEntity<Void> changeStatus(@RequestParam @NotBlank String transactionId ,@RequestParam @NotBlank String isbn){
        transactionService.changeStatus(transactionId , isbn);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/issue/date")
    public ResponseEntity<Integer> findByIssueDateCount(@RequestParam("date")
                                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        System.out.println(date);
        return ResponseEntity.ok( transactionService.findByIssueDateCount(date));
    }

    @GetMapping("/return/date")
    public ResponseEntity<Integer> findByReturnDateCount(@RequestParam LocalDateTime date){
        return ResponseEntity.ok( transactionService.findByReturnDateCount(date));
    }




    


}
