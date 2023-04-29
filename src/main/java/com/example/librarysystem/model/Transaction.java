package com.example.librarysystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean IsReturned;

    private LocalDateTime issueDate;

    private LocalDateTime dueDate;


    // constructors

    public Transaction() { }

    public Transaction(Book book, User user, Boolean isReturned,
                       LocalDateTime issueDate, LocalDateTime dueDate) {
        this.id = "";
        this.book = book;
        this.user = user;
        IsReturned = isReturned;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    // getters

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Boolean getReturned() {
        return IsReturned;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }


    // setters





}
