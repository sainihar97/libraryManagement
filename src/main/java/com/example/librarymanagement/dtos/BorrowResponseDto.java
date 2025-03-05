package com.example.librarymanagement.dtos;

import java.time.LocalDateTime;

public class BorrowResponseDto {

    private LocalDateTime returnDate;
    private String bookName;

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BorrowResponseDto(String bookName, LocalDateTime returnDate){
        this.bookName=bookName;
        this.returnDate=returnDate;
    }

}
