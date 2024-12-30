package com.LibraryManagement.LibraryManagementSystem.Repository;


//import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.LibraryManagementSystem.Model.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}