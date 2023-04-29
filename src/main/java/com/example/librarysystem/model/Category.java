package com.example.librarysystem.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();



    // constructors
    public Category() { }

    public Category(String categoryName) {
        this.id="";
        this.categoryName = categoryName;
    }

    public Category(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }


    // getter
    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Book> getBooks() {
        return books;
    }


    // setter
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
