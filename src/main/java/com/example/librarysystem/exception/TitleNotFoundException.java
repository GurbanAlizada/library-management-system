package com.example.librarysystem.exception;

public class TitleNotFoundException extends RuntimeException{
    public TitleNotFoundException(String message) {
        super(message);
    }
}
