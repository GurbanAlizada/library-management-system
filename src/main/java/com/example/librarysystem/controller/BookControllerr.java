package com.example.librarysystem.controller;

import com.example.librarysystem.dto.request.AddBookRequest;
import com.example.librarysystem.dto.response.BookDto;
import com.example.librarysystem.dto.response.PopularBooksDto;
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
    public ResponseEntity<List<BookDto>> getAllBookByCategoryId(@RequestParam List<Long> categoryIds){
        return ResponseEntity.ok(bookService.getAllBookByCategoryId(categoryIds));
    }


    @GetMapping("/popular/books")
    public ResponseEntity<List<PopularBooksDto>> getMostPopularBooks(){
        return ResponseEntity.ok(bookService.getMostPopularBooks());
    }



    @GetMapping("/user/{finCode}")
    public ResponseEntity<List<BookDto>> getAllGivenBooksByUserFinCode(@PathVariable String finCode){
        return null;
    }


    @GetMapping("/getAllBookIsHere")
    public ResponseEntity<List<BookDto>> getAllBookIsHere(){
        return null;
    }

    @GetMapping("/getAllBookIsHere/{title}")
    public ResponseEntity<List<BookDto>> getAllBookIsHereAndByTitle(@PathVariable String title){
        return null;
    }







}
