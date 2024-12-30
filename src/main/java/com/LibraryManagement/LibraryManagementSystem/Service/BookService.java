package com.LibraryManagement.LibraryManagementSystem.Service;



import org.springframework.stereotype.Service;

import com.LibraryManagement.LibraryManagementSystem.Model.BookModel;
import com.LibraryManagement.LibraryManagementSystem.Repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

  
    public BookModel saveBook(BookModel book) {
        return bookRepository.save(book);
    }

   
    public BookModel getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + id));
    }

  
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
