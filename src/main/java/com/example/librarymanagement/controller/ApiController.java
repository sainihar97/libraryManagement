package com.example.librarymanagement.controller;

import com.example.librarymanagement.dtos.*;
import com.example.librarymanagement.service.ServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class ApiController {

    private final ServiceInterface serviceInterface;
    public ApiController(ServiceInterface serviceInterface){
        this.serviceInterface=serviceInterface;
    }
     @PostMapping("/update")
    public ResponseEntity<UpdateBooksDto> updateBook(@RequestBody UpdateBooksDto updateBooksDto, @RequestHeader("Authorization") String token){

         UpdateBooksDto response=serviceInterface.updateBook(updateBooksDto);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/edit/{bookId}")
   public ResponseEntity<EditDetailsDto> editBookDetails(@PathVariable("bookId") long id,@RequestBody EditDetailsDto editDetailsDto){
        EditDetailsDto response=serviceInterface.editBook(id,editDetailsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getDetails/{bookCode}")
    public ResponseEntity<GetResponseDTo> getDetails(@PathVariable("bookCode") long bookCode){

       GetResponseDTo response=serviceInterface.getDetails(bookCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/searchBy")
    public ResponseEntity<List<String>> searchBy(@RequestBody SearchRequestDto searchRequestDto){


        List<String> response=serviceInterface.searchBy(searchRequestDto);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/borrow/{bookCode}/{userName}")
    public ResponseEntity<BorrowResponseDto> borrow(@PathVariable("bookCode") long bookCode,@PathVariable("userName") String userName){
        BorrowResponseDto response=serviceInterface.borrow(bookCode,userName);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/return/{bookCode}")
    public ResponseEntity<ReturnResponseDto> returning(@PathVariable("bookCode") long bookCode){

        ReturnResponseDto response = serviceInterface.returning(bookCode);

        return ResponseEntity.ok(response);
    }


}
