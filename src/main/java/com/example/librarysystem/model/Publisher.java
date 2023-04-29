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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    private String publisher;

    @ManyToMany(mappedBy = "publishers")
    private List<Book> books = new ArrayList<>();


    // constructor
    public Publisher() {}

    public Publisher(String id, String publisher) {
        this.id = id;
        this.publisher = publisher;
    }

    public Publisher(String publisher) {
        this.id="";
        this.publisher = publisher;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public List<Book> getBooks() {
        return books;
    }

    // setter
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
