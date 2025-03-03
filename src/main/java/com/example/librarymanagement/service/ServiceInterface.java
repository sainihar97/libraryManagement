package com.example.librarymanagement.service;

import com.example.librarymanagement.dtos.EditDetailsDto;
import com.example.librarymanagement.dtos.GetRequestDetailsDto;
import com.example.librarymanagement.dtos.GetResponseDTo;
import com.example.librarymanagement.dtos.UpdateBooksDto;

public interface ServiceInterface {

    UpdateBooksDto updateBook(UpdateBooksDto updateBooksDto);

    EditDetailsDto editBook(long id,EditDetailsDto editDetailsDto);

    GetResponseDTo getDetails(long bookCode);
}
