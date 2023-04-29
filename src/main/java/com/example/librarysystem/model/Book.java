package com.example.librarysystem.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    @Column(unique = true)
    private String isbn;

    private String bookName;

    @ManyToMany
    @JoinTable(
            name = "book_publisher",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id")
    )
    private List<Publisher> publishers;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    private Integer unitsInStock;


    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;


    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions = new ArrayList<>();



    // constructors

    public Book() {}

    public Book(String id, String isbn, String bookName, List<Publisher> publishers,
                List<Author> authors, Integer unitsInStock,
                List<Category> categories, List<Transaction> transactions) {
        this.id = "";
        this.isbn = isbn;
        this.bookName = bookName;
        this.publishers = publishers;
        this.authors = authors;
        this.unitsInStock = unitsInStock;
        this.categories = categories;
        this.transactions = transactions;
    }

    // getters

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    //setters

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }


}
