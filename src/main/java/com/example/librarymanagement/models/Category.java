package com.example.librarymanagement.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category; // ✅ Correct spelling

    // ✅ Default constructor (required by JPA)
    public Category() {}

    // ✅ Constructor for creating new categories
    public Category(String category) {
        this.category = category;
    }

    public Category(Category category) {
    }

    // ✅ Correct getter and setter methods
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
