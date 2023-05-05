package com.example.librarysystem.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<Detail> books = new ArrayList<>();



    // constructors
    public Category() { }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }


    // getter
    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Detail> getBooks() {
        return books;
    }

    // setter


    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setBooks(List<Detail> books) {
        this.books = books;
    }
}
