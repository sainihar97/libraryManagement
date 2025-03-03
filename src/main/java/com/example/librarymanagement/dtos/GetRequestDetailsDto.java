package com.example.librarymanagement.dtos;

public class GetRequestDetailsDto {


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    private Long bookId;
    private Long bookCode;


}
