package com.example.librarymanagement.dtos;

import com.example.librarymanagement.models.AuthorDeatils;
import com.example.librarymanagement.models.Category;

public class SearchRequestDto {

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    private String bookName;

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    private Long bookCode;

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public AuthorDeatils getAuthorName() {
//        return authorName;
//    }
//
//    public void setAuthorName(AuthorDeatils authorName) {
//        this.authorName = authorName;
//    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthorName() {
        return authorName;
    }

    private String category;
    private String authorName;
}
