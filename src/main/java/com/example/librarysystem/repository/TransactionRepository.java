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



    List<Transaction> findByReturnDate(LocalDateTime returnDate);


}
