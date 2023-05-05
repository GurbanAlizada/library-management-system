package com.example.librarysystem.repository;

import com.example.librarysystem.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {


    List<Transaction> findByBook_IsbnAndIsReturnedFalse(String isbn);


    //@Query("select t from Transaction t where function('DATE' , t.issueDate) = :date  ")
     @Query(nativeQuery = true , value = "SELECT * FROM transactions WHERE DATE_FORMAT(issue_date, '%Y-%m-%d') = :date ;")
    List<Transaction> findByIssueDateIsReturnFalse(@Param("date") LocalDate date);



    //@Query("select t from Transaction t where function('DATE' , t.issueDate) = :date ")
    @Query(nativeQuery = true , value = "SELECT * FROM transactions WHERE DATE_FORMAT(return_date, '%Y-%m-%d') = :date ;")
    List<Transaction> findByReturnDateIsReturnTrue(@Param("date") LocalDate date);



   /*@Query(nativeQuery = true , value = "select a.author ,count(a.id) as count  from transactions t " +
            "inner join books b on b.id=t.book_id " +
            "inner join details d on d.id = b.detail_id " +
            "inner join detail_author da on da.detail_id=d.id " +
            "inner join authors a on da.author_id=a.id " +
            "group by a.id " +
            "order by count(a.id) desc; ")*/
    @Query("select a.author as author ,count(a.author) as count from Transaction t   inner join t.book b inner join b.detail d inner join d.authors a group by a.author order by count(a.author) desc ")
    List<Object[]> getMostPopularAuthorsAndCount();


    //@Query("select t from Transaction t where function('DATE' , t.returnDate) = :returnDate ")
    @Query(nativeQuery = true , value = "SELECT * FROM transactions WHERE DATE_FORMAT(return_date, '%Y-%m-%d') = :returnDate ;")
    List<Transaction> findByReturnDate(@Param("returnDate") LocalDate returnDate);



    List<Transaction> getByUser_FinCode(String finCode);





}
