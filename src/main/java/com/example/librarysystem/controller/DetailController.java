package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddDetailRequest;
import com.example.librarysystem.dto.response.DetailDto;
import com.example.librarysystem.service.DetailService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/detail")
@Validated
public class DetailController {

    private final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @PostMapping
    public ResponseEntity<Void> addDetail(@Valid @RequestBody AddDetailRequest request){
        detailService.addDetail(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<DetailDto>> getAll(){
        return ResponseEntity.ok(detailService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<DetailDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(detailService.getById(id));
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
