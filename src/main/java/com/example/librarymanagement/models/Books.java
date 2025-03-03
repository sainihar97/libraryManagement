package com.example.librarymanagement.models;


import jakarta.persistence.*;

@Entity
public class Books {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    private String bookName;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    private long code;

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    private boolean isBorrowed;


    @ManyToOne
    @JoinColumn(name = "auth_name")  // This creates the category_id FK in the Books table

    private AuthorDeatils authorDetails;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AuthorDeatils getAuthorDetails() {
        return authorDetails;
    }

    public void setAuthorDetails(AuthorDeatils authorDetails) {
        this.authorDetails = authorDetails;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")  // This creates the category_id FK in the Books table
    private Category category;



}
