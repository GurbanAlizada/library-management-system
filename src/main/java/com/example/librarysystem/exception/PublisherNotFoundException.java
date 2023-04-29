package com.example.librarysystem.exception;

public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException(String message) {
        super(message);
    }
}
