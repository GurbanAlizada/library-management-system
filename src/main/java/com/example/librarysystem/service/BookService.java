package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddBookRequest;
import com.example.librarysystem.model.*;
import com.example.librarysystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final TitleService titleService;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;


    public BookService(BookRepository bookRepository, TitleService titleService, AuthorService authorService,
                       CategoryService categoryService, PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.titleService = titleService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
    }


    public void addBook(AddBookRequest request) {

        Title title = titleService.getTitleById(request.titleId());

        List<String> publisherIDs = request.publisherIDs();
        List<Publisher> publishers = new ArrayList<>();
        for(String id : publisherIDs){
            publishers.add(publisherService.getPublisherById(id));
        }


        List<String> aurhorIDs = request.aurhorIDs();
        List<Author> authors = new ArrayList<>();
        for (String id : aurhorIDs){
            authors.add(authorService.getAuthorById(id));
        }

        List<String> categoryIDs = request.categoryIDs();
        List<Category> categories = new ArrayList<>();
        for (String id : categoryIDs){
            categories.add(categoryService.getCategoryById(id));
        }

        Book book = new Book(request.isbn() , title , publishers , authors , request.unitsInStock() , categories );
        bookRepository.save(book);

    }





}
