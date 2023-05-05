package com.example.librarysystem.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isReturned;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime issueDate;

    private LocalDateTime dueDate;

    private LocalDateTime returnDate;


    // constructors

    public Transaction() { }

    public Transaction(Book book, User user, Boolean isReturned,
                       LocalDateTime issueDate, LocalDateTime dueDate , LocalDateTime returnDate) {
        this.book = book;
        this.user = user;
        this.isReturned = isReturned;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    // getters

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Boolean getReturned() {
        return isReturned;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    // setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
