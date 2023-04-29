package com.example.librarysystem.repository;

import com.example.librarysystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction , String> {


}
