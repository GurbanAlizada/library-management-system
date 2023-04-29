package com.example.librarysystem.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "titles")
public class Title implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID" , strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String title;

    @OneToMany(mappedBy = "title")
    private List<Book> books;

    // constructor
    public Title() {}

    public Title( String title) {
        this.id = "";
        this.title = title;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Book> getBooks() {
        return books;
    }


}
