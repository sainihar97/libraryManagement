package com.example.librarymanagement.userRepo;

import com.example.librarymanagement.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {


    Optional<Category> findByCategory(Category category);

    Optional<Category> findByCategory(String category);




}
