package com.example.librarysystem.repository;

import com.example.librarysystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction , String> {



    List<Transaction> findByIssueDate(LocalDateTime issueDate);


    List<Transaction> findByReturnDate(LocalDateTime returnDate);


}
