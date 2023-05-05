package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddCategoryRequest;
import com.example.librarysystem.dto.response.BookDto;
import com.example.librarysystem.dto.response.CategoryDto;
import com.example.librarysystem.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/category")
@Validated
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public ResponseEntity<Void> addCategory(@Valid @RequestBody AddCategoryRequest request){
        categoryService.addCategory(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }


    @GetMapping("/categoryName/{categoryName}")
    public ResponseEntity<CategoryDto> getByCategoryName(String categoryName){
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
