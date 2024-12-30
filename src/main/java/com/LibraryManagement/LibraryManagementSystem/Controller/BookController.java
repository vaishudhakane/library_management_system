package com.LibraryManagement.LibraryManagementSystem.Controller;

//import com.example.library.model.Book;
//import com.example.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.LibraryManagement.LibraryManagementSystem.Model.BookModel;
import com.LibraryManagement.LibraryManagementSystem.Service.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")


public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   @GetMapping
    public String getAllBooks(Model model) {
        List<BookModel> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/new")
   public String showCreateBookForm(Model model) {
        model.addAttribute("book", new BookModel());
       return "books/form";
    }

   @PostMapping
   public String saveBook(@ModelAttribute BookModel book) {
        bookService.saveBook(book);
        return "redirect:/books";
   }

    @GetMapping("/edit/{id}")
   public String showEditBookForm(@PathVariable Long id, Model model) {
        BookModel book = bookService.getBookById(id);
        model.addAttribute("book", book);
       return "books/form";
    }

   @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute BookModel book) {
        book.setId(id);
       bookService.saveBook(book);
       return "redirect:/books";
   }

    @GetMapping("/delete/{id}")
   public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
