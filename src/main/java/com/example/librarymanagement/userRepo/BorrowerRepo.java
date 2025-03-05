package com.example.librarymanagement.userRepo;

import com.example.librarymanagement.models.BorrowerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BorrowerRepo extends JpaRepository<BorrowerDetails,Long> {


    Optional<BorrowerDetails> findByBooksId(Long bookId);
}
