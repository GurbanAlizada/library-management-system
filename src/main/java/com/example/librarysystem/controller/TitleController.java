package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddTitleRequest;
import com.example.librarysystem.dto.response.TitleDto;
import com.example.librarysystem.service.TitleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/title")
@Validated
public class TitleController {

    private final TitleService titleService;


    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @PostMapping
    public ResponseEntity<Void> addTitle(@Valid @RequestBody AddTitleRequest request){
        titleService.addTitle(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<TitleDto>> getAll(){
        return ResponseEntity.ok(titleService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TitleDto> getById(@PathVariable String id){
        return ResponseEntity.ok(titleService.getById(id));
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
