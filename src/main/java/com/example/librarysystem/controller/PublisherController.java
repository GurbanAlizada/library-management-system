package com.example.librarysystem.controller;


import com.example.librarysystem.dto.request.AddPublisherRequest;
import com.example.librarysystem.dto.response.PublisherDto;
import com.example.librarysystem.service.PublisherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/publisher")
@Validated
public class PublisherController {

    private final PublisherService publisherService;


    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @PostMapping
    public ResponseEntity<Void> addPublisher(@Valid @RequestBody AddPublisherRequest request){
        publisherService.addPublisher(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public ResponseEntity<List<PublisherDto>> getAll(){
        return ResponseEntity.ok(publisherService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getById(@PathVariable @NotBlank String id){
        return ResponseEntity.ok(publisherService.getById(id));
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
