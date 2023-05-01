package com.example.librarysystem.repository;

import com.example.librarysystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction , String> {



    @Query(nativeQuery = true , value = "SELECT * FROM transactions WHERE DATE_FORMAT(issue_date, '%Y-%m-%d') = :date ;")
    List<Transaction> findByIssueDate(@Param("date") LocalDate date);



    @Query(nativeQuery = true , value = "SELECT * FROM transactions WHERE DATE_FORMAT(return_date, '%Y-%m-%d') = :returnDate ;")
    List<Transaction> findByReturnDate(@Param("returnDate") LocalDate returnDate);


    @Query(nativeQuery = true , value = "select t.*  ,  count(ba.book_id) as count from transactions t " +
            "inner join books b on b.id=t.book_id " +
            "inner join book_author ba on b.id=ba.book_id " +
            "inner join authors a on a.id=ba.author_id " +
            "group by ba.author_id " +
            "order by ba.author_id desc " +
            "limit 3;")
    List<Transaction> foo();




    /*

    Transactionlar bas veren kitablar en cox hansi mueliflerindi

     */



}
