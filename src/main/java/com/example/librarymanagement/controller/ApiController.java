package com.example.librarymanagement.controller;

import com.example.librarymanagement.dtos.EditDetailsDto;
import com.example.librarymanagement.dtos.GetRequestDetailsDto;
import com.example.librarymanagement.dtos.GetResponseDTo;
import com.example.librarymanagement.dtos.UpdateBooksDto;
import com.example.librarymanagement.service.ServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


}
