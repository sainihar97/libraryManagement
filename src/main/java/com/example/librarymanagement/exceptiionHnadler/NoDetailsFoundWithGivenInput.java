package com.example.librarymanagement.exceptiionHnadler;

public class NoDetailsFoundWithGivenInput extends RuntimeException{

    public NoDetailsFoundWithGivenInput(String message){
        super(message);
    }
}
