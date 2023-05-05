package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddAuthorRequest;
import com.example.librarysystem.dto.response.AuthorDto;
import com.example.librarysystem.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/author")
@Validated
public class AuthorController {


    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @PostMapping
    public ResponseEntity<Void> addAuthor( @RequestBody @Valid AddAuthorRequest request){
        authorService.addAuthor(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getById(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(authorService.getById(id));
    }


    @GetMapping("/authorName/{authorName}")
    public ResponseEntity<AuthorDto> getByAuthorName(String authorName){
        return null;
    }


    @GetMapping("/search")
    public ResponseEntity<AuthorDto> search(String key){
        return null;
    }


    @PutMapping
    public ResponseEntity<Void> update(){

        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){

        return null;
    }




}
