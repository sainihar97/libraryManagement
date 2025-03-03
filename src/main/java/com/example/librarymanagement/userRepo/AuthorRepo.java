package com.example.librarymanagement.userRepo;

import com.example.librarymanagement.models.AuthorDeatils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthorRepo extends JpaRepository<AuthorDeatils,Long> {

    Optional<AuthorDeatils> findByAuthName(String authName);
}
