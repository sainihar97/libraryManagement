package com.example.librarymanagement.exceptiionHnadler;

public class BookWithIdnotfound extends RuntimeException{

public BookWithIdnotfound(String message){
    super(message);
}
}
