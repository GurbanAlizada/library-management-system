package com.example.librarysystem.repository;

import com.example.librarysystem.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DetailRepository extends JpaRepository<Detail, Long> {


    Optional<Detail> findByTitle(String title);

    //   @Query("SELECT b FROM Book b JOIN b.categories c WHERE c.name = :categoryName")
    @Query("SELECT t from Detail t join t.books b where b.isbn =: isbn")
    Optional<Detail> foo(@Param("isbn") String isbn);


}
