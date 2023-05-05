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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "detail_id")
    private Detail detail;

    private Boolean here;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @OneToMany(mappedBy = "book")
    private List<Transaction> transactions = new ArrayList<>();




    // constructors

    public Book() {}

    public Book(String isbn,
                Detail detail,
                Publisher publisher,
                Boolean here) {
        this.isbn = isbn;
        this.detail = detail;
        this.publisher = publisher;
        this.here=here;
    }

    public Boolean getHere() {
        return here;
    }

    // getters

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Detail getDetail() {
        return detail;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setHere(Boolean here) {
        this.here = here;
    }
}
