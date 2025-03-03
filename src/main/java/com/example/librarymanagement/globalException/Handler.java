package com.example.librarymanagement.globalException;


import com.example.librarymanagement.exceptiionHnadler.BookWithIdnotfound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(BookWithIdnotfound.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExists(BookWithIdnotfound ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
