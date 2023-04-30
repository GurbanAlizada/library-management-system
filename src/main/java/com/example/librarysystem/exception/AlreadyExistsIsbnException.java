package com.example.librarysystem.exception;

public class AlreadyExistsIsbnException extends RuntimeException{
    public AlreadyExistsIsbnException(String message) {
        super(message);
    }
}
