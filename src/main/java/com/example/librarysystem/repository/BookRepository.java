package com.example.librarysystem.repository;

import com.example.librarysystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book , Long> {


    Optional<Book> getByIsbn(String isbn);

    List<Book> findByDetail_Categories_IdIn(List<Long> ids);

    List<Book> findByHereTrueAndDetail_Title(String title);


   /* @Query(nativeQuery = true , value = "select d.title , count(d.id) from transactions  " +
            "inner join books b on b.id = t.book_id " +
            "inner join details d on d.id = b.detail_id " +
            "group by d.id " +
            "order by count(d.id) desc " +
            "limit 3;")*/
    @Query("select t.book.detail.id as book_id ,count(t.book.detail.id) as count from Book  b inner join b.transactions t group by t.book.detail.id order by count(t.book.detail.id) desc ")
    List<Object[]> getMostPopularBooks();




}
