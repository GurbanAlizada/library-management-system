package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddAuthorRequest;
import com.example.librarysystem.dto.response.AuthorDto;
import com.example.librarysystem.exception.AuthorNotFoundException;
import com.example.librarysystem.model.Author;
import com.example.librarysystem.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Transactional
    public void addAuthor(AddAuthorRequest request) {
        Author author = new Author(request.author());
        authorRepository.save(author);
    }


    public List<AuthorDto> getAll() {
        List<Author> authors = authorRepository.findAll();
        final var result = authors.stream()
                .map(n-> AuthorDto.convert(n))
                .collect(Collectors.toList());
        return result;
    }


    public AuthorDto getById(String id) {
        Author author = getAuthorById(id);
        final var result = AuthorDto.convert(author);
        return result;
    }






    protected Author getAuthorById(String id){
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new AuthorNotFoundException("author not found : " + id));
        return author;
    }





}
