package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddTransactionRequest;
import com.example.librarysystem.dto.response.TransactionDto;
import com.example.librarysystem.exception.BookNotFoundException;
import com.example.librarysystem.exception.TransactionNotFoundException;
import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Title;
import com.example.librarysystem.model.Transaction;
import com.example.librarysystem.model.User;
import com.example.librarysystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final BookService bookService;
    private final TitleService titleService;


    public TransactionService(TransactionRepository transactionRepository, UserService userService, BookService bookService, TitleService titleService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.bookService = bookService;
        this.titleService = titleService;
    }


    @Transactional
    public void addTransaction(AddTransactionRequest request) {

        Book book = bookService.getBookByIsbn(request.isbn());

        book.getTransactions().stream().forEach(n->{
            if (n.getReturned()==false){
                throw new BookNotFoundException("book not found");
            }
        });

        Title title = book.getTitle();
        Integer unitsInStock = title.getUnitsInStock();
        title.setUnitsInStock(--unitsInStock);
        User user = userService.getByFinCode(request.finCode());
        Transaction transaction = new Transaction(
                book ,
                user ,
                false ,
                LocalDateTime.now() ,
                LocalDateTime.now().plusDays(request.days()));
        transactionRepository.save(transaction);
    }


    @Transactional
    public void changeStatus(String transactionId , String isbn ) {
        Transaction transaction = getTransactionById(transactionId);
        Book book = bookService.getBookByIsbn(isbn);
        Title title = book.getTitle();
        Integer unitsInStock = title.getUnitsInStock();
        title.setUnitsInStock(++unitsInStock);
        transaction.setReturned(true);
        transaction.setReturnDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }
//
//   public List<TransactionDto> findByIssueDate(LocalDateTime date){
//        return transactionRepository.findByIssueDate(date)
//                .stream()
//                .map(TransactionDto::convert)
//                .collect(Collectors.toList());
//   }



//    public List<TransactionDto> findByReturnDate(LocalDateTime date){
//        return transactionRepository.findByReturnDate(date)
//                .stream()
//                .map(TransactionDto::convert)
//                .collect(Collectors.toList());
//    }


    public Integer findByIssueDateCount(LocalDate date){
        return transactionRepository.findByIssueDate(date).size();
    }



    public Integer findByReturnDateCount(LocalDate date){
       return transactionRepository.findByReturnDate(date).size();
    }



    public List<TransactionDto> foo(){
        List<Transaction> transactions = transactionRepository.foo();
        transactions.stream().map(n->n.getBook().getAuthors());
        return transactions.stream().map(n->TransactionDto.convert(n)).collect(Collectors.toList());
    }







    protected Transaction getTransactionById(String transactionId){
        return transactionRepository.findById(transactionId)
                .orElseThrow(()->new TransactionNotFoundException("transaction not found : " + transactionId));
    }

}
