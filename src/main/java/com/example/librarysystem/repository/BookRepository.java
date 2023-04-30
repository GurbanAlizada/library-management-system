package com.example.librarysystem.repository;

import com.example.librarysystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book , String> {


    Optional<Book> getByIsbn(String isbn);

    List<Book> findByCategories_IdIn(List<String> ids);

}
