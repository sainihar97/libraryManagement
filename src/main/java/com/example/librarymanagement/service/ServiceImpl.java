package com.example.librarymanagement.service;

import com.example.librarymanagement.dtos.*;
import com.example.librarymanagement.exceptiionHnadler.BookWithIdBorrowedException;
import com.example.librarymanagement.exceptiionHnadler.BookWithIdnotfound;
import com.example.librarymanagement.exceptiionHnadler.NoDetailsFoundWithGivenInput;
import com.example.librarymanagement.models.AuthorDeatils;
import com.example.librarymanagement.models.Books;
import com.example.librarymanagement.models.BorrowerDetails;
import com.example.librarymanagement.models.Category;
import com.example.librarymanagement.userRepo.AuthorRepo;
import com.example.librarymanagement.userRepo.BookRepo;
import com.example.librarymanagement.userRepo.BorrowerRepo;
import com.example.librarymanagement.userRepo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ServiceInterface {

    private final BorrowerRepo borrowerRepo;
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private CategoryRepo categoryRepo;

    @Autowired
    public ServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, CategoryRepo categoryRepo, BorrowerRepo borrowerRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.categoryRepo = categoryRepo;
        this.borrowerRepo = borrowerRepo;
    }


    @Override
    public UpdateBooksDto updateBook(UpdateBooksDto updateBooksDto) {
        Category category = categoryRepo.findByCategory(updateBooksDto.getCategory()).
                orElseGet(() -> categoryRepo.save(new Category(updateBooksDto.getCategory())));
        // Books books=bookRepo.findById()

        AuthorDeatils authorDeatils = authorRepo.findByAuthName(updateBooksDto.getAuthName()).
                orElseGet(() -> authorRepo.save(new AuthorDeatils(updateBooksDto.getAuthName())));

        Books books = new Books();
        books.setBookName(updateBooksDto.getBookName());
        books.setCode(updateBooksDto.getCode());
        books.setBorrowed(false);
        books.setCategory(category);
        books.setAuthorDetails(authorDeatils);

        // books.setBookCode(updateBooksDto.getBookCode()); // ADD THIS LINE!


        bookRepo.save(books);

        return new UpdateBooksDto(books.getBookName(), books.getCode(), false, books.getCategory().getCategory(), books.getAuthorDetails().getAuthName());


        // return UpdateBooksDto;
    }

    @Override
    public EditDetailsDto editBook(long id, EditDetailsDto editDetailsDto) {
        //EditDetailsDto editDetailsDto = new EditDetailsDto();
        Optional<Books> optional = bookRepo.findById(id);
        if (optional.isEmpty()) {
            throw new BookWithIdnotfound("book with " + id + "is not found");
        }
        Books books = optional.get();

        if (editDetailsDto.getBookName() != null) {
            books.setBookName(editDetailsDto.getBookName());
        }

        if (editDetailsDto.getCategoryName() != null) {

            String categoryName = editDetailsDto.getCategoryName();

            Category category = categoryRepo.findByCategory(categoryName)
                    .orElseGet(() -> {
                        Category newCategory = new Category();
                        newCategory.setCategory(categoryName);
                        return categoryRepo.save(newCategory);  // Save new category in DB
                    });

            books.setCategory(category);

        }

        books.setBorrowed(editDetailsDto.isBorrowed()); // Direct set, no need for != check

        bookRepo.save(books);
        return new EditDetailsDto(books.getBookName(), books.isBorrowed(), books.getCategory());
    }

    @Override
    public GetResponseDTo getDetails(long bookCode) {

        GetResponseDTo getResponseDTo = new GetResponseDTo();
        Optional<Books> book = bookRepo.findByCode(bookCode);


        if (book.isPresent()) {

            Books books = book.get();

            return new GetResponseDTo(books.getBookName(), books.getId(), books.getCode(), books.getAuthorDetails().getAuthName(), books.getCategory().getCategory());


        }
        throw new BookWithIdnotfound("book with the id " + bookCode + "is not valid");


    }

    @Override
    public List<String> searchBy(SearchRequestDto searchRequestDto) {

        List<String> book = new ArrayList<>();

        if (searchRequestDto.getBookName() != null) {
            List<String> bookNames = bookRepo.findBookNamesByBookName(searchRequestDto.getBookName());

            if (bookNames.isEmpty()) {
                throw new NoDetailsFoundWithGivenInput("No books found with the name: " + searchRequestDto.getBookName());
            }

            book.addAll(bookNames);
            return book;
        }


        if (searchRequestDto.getBookCode() != null) {

            List<String> bookNames = bookRepo.findBookNamesByCode(searchRequestDto.getBookCode());

            if (bookNames.isEmpty()) {
                throw new NoDetailsFoundWithGivenInput("No books found with the code: " + searchRequestDto.getBookCode());
            }

            book.addAll(bookNames);
            return book;


        }

        if (searchRequestDto.getCategory() != null) {

            List<String> bookNames = bookRepo.findBookNamesByCategory(searchRequestDto.getCategory());

            if (bookNames.isEmpty()) {
                throw new NoDetailsFoundWithGivenInput("No books found with the category: " + searchRequestDto.getCategory());
            }

            book.addAll(bookNames);
            return book;

        }

        if (searchRequestDto.getAuthorName() != null) {

            book.addAll(bookRepo.findBookNamesByAuthorDetails(searchRequestDto.getAuthorName()));

            return book;

        }
        throw new NoDetailsFoundWithGivenInput("no books found with the given details, pkease try again");
    }

    @Override
    public BorrowResponseDto borrow(long bookCode, String userId) {

        Optional<Books> optional = bookRepo.findBooksByCode(bookCode);

        Books books = optional.get();


        if (optional.isPresent()) {

            if (!books.isBorrowed()) {
                BorrowerDetails borrowerDetails = new BorrowerDetails();
                borrowerDetails.setBorrowedBy(userId);
                borrowerDetails.setBorrowedOn(LocalDateTime.now());
                borrowerDetails.setExpectedReturnedDate(LocalDateTime.now().plusDays(4));
                borrowerDetails.setReturnedDate(null);
                borrowerDetails.setBooks(books);

                books.setBorrowed(true);
                bookRepo.save(books);
                borrowerRepo.save(borrowerDetails);

                // Books borrowedStatus=books.setBorrowed(true);

            } else {
                throw new BookWithIdBorrowedException("book with the given code " + bookCode + "is not available at the moment");
            }


        }


        return new BorrowResponseDto(books.getBookName(), LocalDateTime.now().plusDays(4));
    }

    @Override
    public ReturnResponseDto returning(long bookCode) {
        List<Long> ids = bookRepo.findIdByCode(bookCode);

       Optional<Books> optionalBooks=bookRepo.findByCode(bookCode);
       Books books=optionalBooks.get();

        if (ids.isEmpty()) {
            System.out.println("No book found with code: " + bookCode);
            return null; // Or throw an exception
        }

        Long bookId = ids.get(0); // Get the first id if you expect only one

        Optional<BorrowerDetails> optionalBorrowerDetails = borrowerRepo.findByBooksId(bookId);

        if (optionalBorrowerDetails.isPresent()) {
            BorrowerDetails borrowerDetails = optionalBorrowerDetails.get();

            borrowerDetails.setReturnedDate(LocalDateTime.now());

            long latedays = ChronoUnit.DAYS.between(borrowerDetails.getExpectedReturnedDate(), borrowerDetails.getReturnedDate());

                borrowerDetails.setPenalty(latedays * 90);
                borrowerDetails.setNotEligibleToBorrrow(borrowerDetails.getReturnedDate().plusDays(latedays));

                books.setBorrowed(false);

            borrowerRepo.save(borrowerDetails);

            return new ReturnResponseDto(borrowerDetails.getBorrowedBy(),  borrowerDetails.getPenalty(),borrowerDetails.getNotEligibleToBorrrow());
        } else {
            System.out.println("borrower details isn't found with the book code: " + bookCode);
            return null; // Or throw an exception
        }
    }
}