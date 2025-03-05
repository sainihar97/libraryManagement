package com.example.librarymanagement.userRepo;

import com.example.librarymanagement.models.AuthorDeatils;
import com.example.librarymanagement.models.Books;
import com.example.librarymanagement.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Books,Long> {


    Optional<Books> findById(Long id);

    Optional<Books> findByCode(long bookCode);

    @Query("SELECT b.bookName FROM Books b WHERE b.bookName = :bookName")
    List<String> findBookNamesByBookName(String bookName);

    @Query("SELECT b.bookName FROM Books b WHERE b.code = :code")
    List<String> findBookNamesByCode(long code);

    @Query("SELECT b.bookName FROM Books b WHERE b.authorDetails.authName = :authName")
    List<String> findBookNamesByAuthorDetails(String authName);

    @Query("SELECT b.bookName FROM Books b WHERE b.category.category = :category")
    List<String> findBookNamesByCategory(String category);

    Optional<Books> findBooksByCode(Long bookCode);



    @Query("SELECT b.id FROM Books b WHERE b.code = :bookCode")
    List<Long> findIdByCode(@Param("bookCode") Long bookCode);




}
