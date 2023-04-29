package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddPublisherRequest;
import com.example.librarysystem.dto.response.PublisherDto;
import com.example.librarysystem.exception.PublisherNotFoundException;
import com.example.librarysystem.model.Publisher;
import com.example.librarysystem.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;


    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Transactional
    public void addPublisher(AddPublisherRequest request) {
        Publisher publisher = new Publisher(request.publisher());
        publisherRepository.save(publisher);
    }


    public List<PublisherDto> getAll() {
        List<Publisher> publishers = publisherRepository.findAll();
        final var result = publishers.stream()
                .map(n -> PublisherDto.convert(n))
                .collect(Collectors.toList());
        return result;
    }


    public PublisherDto getById(String id) {
        Publisher publisher = getPublisherById(id);
        final var result =  PublisherDto.convert(publisher);
        return result;
    }


    protected Publisher getPublisherById(String id){
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()-> new PublisherNotFoundException("publisher not found : " + id));

        return publisher;
    }


}
