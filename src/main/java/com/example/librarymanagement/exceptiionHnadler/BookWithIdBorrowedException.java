package com.example.librarymanagement.exceptiionHnadler;

public class BookWithIdBorrowedException extends RuntimeException {

    public BookWithIdBorrowedException(String message){
        super(message);
    }
}
