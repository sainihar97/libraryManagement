package com.example.librarymanagement.models;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
public class BorrowerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String borrowedBy;
    private LocalDateTime borrowedOn;

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(String borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDateTime getBorrowedOn() {
        return borrowedOn;
    }

    public void setBorrowedOn(LocalDateTime borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    private double penalty;

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    private LocalDateTime returnedDate;

    public LocalDateTime getExpectedReturnedDate() {
        return expectedReturnedDate;
    }

    public void setExpectedReturnedDate(LocalDateTime expectedReturnedDate) {
        this.expectedReturnedDate = expectedReturnedDate;
    }

    private LocalDateTime expectedReturnedDate;

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")  // This creates the category_id FK in the Books table
    private Books books;


    public LocalDateTime getNotEligibleToBorrrow() {
        return notEligibleToBorrrow;
    }

    public void setNotEligibleToBorrrow(LocalDateTime notEligibleToBorrrow) {
        this.notEligibleToBorrrow = notEligibleToBorrrow;
    }

    private LocalDateTime notEligibleToBorrrow;






}
