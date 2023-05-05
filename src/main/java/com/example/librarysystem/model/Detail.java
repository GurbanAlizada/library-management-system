package com.example.librarysystem.model;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "details")
public class Detail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;


    private Integer unitsInStock;


    @ManyToMany
    @JoinTable(
            name = "detail_author",
            joinColumns = @JoinColumn(name = "detail_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;




    @ManyToMany
    @JoinTable(
            name = "detail_category",
            joinColumns = @JoinColumn(name = "detail_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;



    @OneToMany(mappedBy = "detail")
    private List<Book> books;

    // constructor
    public Detail() {}

    public Detail(String title,
                  String description,
                  Integer unitsInStock,
                  List<Author> authors,
                  List<Category> categories) {
        this.title = title;
        this.description = description;
        this.unitsInStock = unitsInStock;
        this.authors = authors;
        this.categories = categories;
    }

    // getter

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Book> getBooks() {
        return books;
    }

    // setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
