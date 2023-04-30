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

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;

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

    public Book( String isbn, Title title, List<Publisher> publishers,
                List<Author> authors,
                List<Category> categories) {
        this.id = "";
        this.isbn = isbn;
        this.title = title;
        this.publishers = publishers;
        this.authors = authors;
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

    public Title getTitle() {
        return title;
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

    public void setTitle(Title title) {
        this.title = title;
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
