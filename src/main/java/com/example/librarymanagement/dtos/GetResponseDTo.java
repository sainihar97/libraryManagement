package com.example.librarymanagement.dtos;

public class GetResponseDTo {

    public GetResponseDTo() {

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String bookName;
    private long bookId;
    private long code;
    private String authName;
    private String category;

    public GetResponseDTo(String bookName,long bookId,long code,String authName,String category){
        this.bookName=bookName;
        this.bookId=bookId;
        this.code=code;
        this.authName=authName;
        this.category=category;
    }
}
