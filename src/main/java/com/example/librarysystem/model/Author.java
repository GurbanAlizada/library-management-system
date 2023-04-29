package com.example.librarysystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String author;


    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();


    // constructor
    public Author() {}

    public Author(String id, String author) {
        this.id = id;
        this.author = author;
    }

    public Author(String author) {
        this.id="";
        this.author = author;
    }



    // getter
    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public List<Book> getBooks() {
        return books;
    }

    // setter
    public void setAuthor(String author) {
        this.author = author;
    }




}
