package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddBookRequest;
import com.example.librarysystem.dto.response.BookDto;
import com.example.librarysystem.dto.response.PopularBooksDto;
import com.example.librarysystem.exception.AlreadyExistsIsbnException;
import com.example.librarysystem.exception.BookNotFoundException;
import com.example.librarysystem.model.*;
import com.example.librarysystem.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final DetailService detailService;
    private final PublisherService publisherService;


    public BookService(BookRepository bookRepository,
                       DetailService detailService,
                       PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.detailService = detailService;
        this.publisherService = publisherService;
    }


    @Transactional
    public void addBook(AddBookRequest request) {

        if (bookRepository.getByIsbn(request.isbn()).isPresent()) {
            throw new AlreadyExistsIsbnException("already exist isbn : " + request.isbn());
        }
        Detail detail = detailService.getDetailById(request.detailId());
        Integer unitsInStock = detail.getUnitsInStock();
        detail.setUnitsInStock(++unitsInStock);
        Publisher publisher = publisherService.getPublisherById(request.publisherId());

        Book book = new Book(request.isbn(), detail , publisher , true);
        bookRepository.save(book);
    }


    public BookDto getByIsbn(String isbn) {
        Book book = getBookByIsbn(isbn);
        final var result = BookDto.convert(book);
        return result;
    }

    public List<PopularBooksDto> getMostPopularBooks(){
        List<Object[]> mostPopularBooks = bookRepository.getMostPopularBooks();

        List<PopularBooksDto> result = new ArrayList<>();
        for (Object[] element : mostPopularBooks){
            System.out.println(element[0].toString() +" "+ element[1].toString());
            result.add(PopularBooksDto.convert(
                    detailService.getDetailById(Long.valueOf(element[0].toString())),
                    Long.valueOf(element[1].toString()))
            );
        }
        return result;
    }




    public List<BookDto> getAllBookByCategoryId(List<Long> categoryIds) {
        List<Book> books = bookRepository.findByDetail_Categories_IdIn(categoryIds);
        List<BookDto> result = books.stream().map(BookDto::convert).collect(Collectors.toList());
        return result;
    }


    protected Book getBookByIsbn(String isbn){
        return bookRepository.getByIsbn(isbn)
                .orElseThrow(()-> new BookNotFoundException("book not found : " + isbn));
    }


    protected Book getByBookId(Long id){
        return bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException("book not found : "+id));
    }

}
