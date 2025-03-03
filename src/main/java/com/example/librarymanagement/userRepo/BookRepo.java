package com.example.librarymanagement.userRepo;

import com.example.librarymanagement.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Books,Long> {


    Optional<Books> findById(Long id);

    Optional<Books> findByCode(long bookCode);


}
