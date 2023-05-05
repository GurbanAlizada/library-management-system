package com.example.librarysystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "publishers")
public class Publisher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String publisher;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();


    // constructor
    public Publisher() {}

    public Publisher(String publisher) {
        this.publisher = publisher;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<Book> getBooks() {
        return books;
    }


    // setter


    public void setId(Long id) {
        this.id = id;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
