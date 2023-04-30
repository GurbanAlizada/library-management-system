package com.example.librarysystem.repository;

import com.example.librarysystem.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title, String> {


    Optional<Title> findByTitle(String title);

    //   @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.name = :categoryName")
    @Query("SELECT t from Title t join t.books b where b.isbn =: isbn")
    Optional<Title> foo(@Param("isbn") String isbn);


}
