package com.example.librarysystem.controller;

import com.example.librarysystem.dto.request.AddBookRequest;
import com.example.librarysystem.dto.response.BookDto;
import com.example.librarysystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getByIsbn(@PathVariable String isbn){
        return ResponseEntity.ok(bookService.getByIsbn(isbn));
    }


    @GetMapping("/category")
    public ResponseEntity<List<BookDto>> getAllBookByCategoryId(@RequestParam List<String> categoryIds){
        return ResponseEntity.ok(bookService.getAllBookByCategoryId(categoryIds));
    }

    @GetMapping("/user/{finCode}")
    public ResponseEntity<List<BookDto>> getAllGivenBooksByUserFinCode(@PathVariable String finCode){
        return null;
    }





}
