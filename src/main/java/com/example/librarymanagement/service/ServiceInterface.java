package com.example.librarymanagement.service;

import com.example.librarymanagement.dtos.*;
import com.example.librarymanagement.models.Books;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ServiceInterface {

    UpdateBooksDto updateBook(UpdateBooksDto updateBooksDto);

    EditDetailsDto editBook(long id, EditDetailsDto editDetailsDto);

    GetResponseDTo getDetails(long bookCode);

    List<String> searchBy(SearchRequestDto searchRequestDto);

    BorrowResponseDto borrow(long bookCode,String userId);

    ReturnResponseDto returning(long bookCode);

}
