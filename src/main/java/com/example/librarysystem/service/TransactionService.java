package com.example.librarysystem.service;


import com.example.librarysystem.dto.request.AddTransactionRequest;
import com.example.librarysystem.dto.response.PopularAuthorsDto;
import com.example.librarysystem.dto.response.TransactionDateDto;
import com.example.librarysystem.dto.response.TransactionDto;
import com.example.librarysystem.exception.BookNotFoundException;
import com.example.librarysystem.exception.TransactionNotFoundException;
import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Detail;
import com.example.librarysystem.model.Transaction;
import com.example.librarysystem.model.User;
import com.example.librarysystem.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final BookService bookService;


    public TransactionService(TransactionRepository transactionRepository, UserService userService, BookService bookService) {
        this.transactionRepository = transactionRepository;
        this.userService = userService;
        this.bookService = bookService;
    }


    @Transactional
    public void addTransaction(AddTransactionRequest request) {

        Book book = bookService.getBookByIsbn(request.isbn());

        book.getTransactions().stream().forEach(n->{
            if (n.getReturned()==false){
                throw new BookNotFoundException("book not found");
            }
        });

        book.setHere(false);
        Detail detail = book.getDetail();
        Integer unitsInStock = detail.getUnitsInStock();
        detail.setUnitsInStock(--unitsInStock);
        User user = userService.getByFinCode(request.finCode());
        Transaction transaction = new Transaction(
                book ,
                user ,
                false ,
                LocalDateTime.now() ,
                LocalDateTime.now().plusDays(request.days()),
                null
        );
        transactionRepository.save(transaction);
    }


    @Transactional
    public void changeStatus( String isbn  ) {
        Book book = bookService.getBookByIsbn(isbn);
        List<Transaction> transactions = transactionRepository.findByBook_IsbnAndIsReturnedFalse(isbn);
        Transaction transaction = transactions.get(0);
        // List<Transaction> transactions = book.getTransactions().stream().filter(n -> n.getReturned() == false).collect(Collectors.toList());
        //Transaction transaction = transactions.get(0);
        book.setHere(true);
        Detail detail = book.getDetail();
        Integer unitsInStock = detail.getUnitsInStock();
        detail.setUnitsInStock(++unitsInStock);
        transaction.setReturned(true);
        transaction.setReturnDate(LocalDateTime.now());
        transactionRepository.save(transaction);
    }




    public TransactionDateDto findByIssueDateIsReturnFalseCount(LocalDate date){
        List<Transaction> transactions = transactionRepository.findByIssueDateIsReturnFalse(date);
        List<TransactionDto> transactionDtos = transactions
                .stream()
                .map(TransactionDto::convert)
                .collect(Collectors.toList());
        TransactionDateDto result = new TransactionDateDto(transactionDtos , transactions.size());
        return result;
    }


    public TransactionDateDto findByReturnDateIsReturnTrueCount(LocalDate date){
        List<Transaction> transactions = transactionRepository.findByReturnDateIsReturnTrue(date);
        List<TransactionDto> transactionDtos = transactions
                .stream()
                .map(TransactionDto::convert)
                .collect(Collectors.toList());
        TransactionDateDto result = new TransactionDateDto(transactionDtos , transactions.size());
        return result;
    }







    public List<PopularAuthorsDto> getMostPopularAuthorsAndCount(){
        List<Object[]> foo = transactionRepository.getMostPopularAuthorsAndCount();
        List<PopularAuthorsDto> result = new ArrayList<>();

        for (Object[] objects : foo){
            result.add(new PopularAuthorsDto(objects[0].toString() ,
                    Integer.valueOf(objects[1].toString())));
        }

        return result;
    }


    public List<TransactionDto> getByUser_FinCode(String finCode){
        List<Transaction> transactions = transactionRepository.getByUser_FinCode(finCode);
        List<TransactionDto> result = transactions.stream()
                .map(TransactionDto::convert)
                .collect(Collectors.toList());
        return result;
    }




    protected Transaction getTransactionById(Long transactionId){
        return transactionRepository.findById(transactionId)
                .orElseThrow(()->new TransactionNotFoundException("transaction not found : " + transactionId));
    }

}
