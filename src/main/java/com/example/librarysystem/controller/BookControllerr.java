package com.example.librarysystem.controller;

import com.example.librarysystem.dto.request.AddBookRequest;
import com.example.librarysystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/book")
public class BookControllerr {

    private final BookService bookService;


    public BookControllerr(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public ResponseEntity<Void> addBook(@Valid @RequestBody AddBookRequest request){
        bookService.addBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }




}
