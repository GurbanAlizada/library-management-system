package com.example.librarysystem.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;


    @ManyToMany(mappedBy = "authors")
    private List<Detail> books = new ArrayList<>();


    // constructor
    public Author() {}

    public Author(String author) {
        this.author = author;
    }



    // getter
    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public List<Detail> getBooks() {
        return books;
    }


    // setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBooks(List<Detail> books) {
        this.books = books;
    }
}
