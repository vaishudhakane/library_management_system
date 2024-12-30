package com.LibraryManagement.LibraryManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.LibraryManagement.LibraryManagementSystem.Model.BorrowingTransactionModel;
import com.LibraryManagement.LibraryManagementSystem.Service.BookService;
import com.LibraryManagement.LibraryManagementSystem.Service.BorrowingTransactionService;
import com.LibraryManagement.LibraryManagementSystem.Service.UserService;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class BorrowingTransactionController {

    private final BorrowingTransactionService transactionService;
    private final BookService bookService;
    private final UserService userService;

    public BorrowingTransactionController(BorrowingTransactionService transactionService, BookService bookService, UserService userService) {
        this.transactionService = transactionService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllTransactions(Model model) {
        List<BorrowingTransactionModel> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
     
        return "transactions/list";
    }

    @GetMapping("/new")
    public String showNewTransactionForm(Model model) {
        model.addAttribute("transaction", new BorrowingTransactionModel());
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("users", userService.getAllUsers());
        return "transactions/form";
    }

    @PostMapping
    public String saveTransaction(@ModelAttribute BorrowingTransactionModel transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/edit/{id}")
    public String showEditTransactionForm(@PathVariable Long id, Model model) {
        BorrowingTransactionModel transaction = transactionService.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("users", userService.getAllUsers());
        return "transactions/form";
    }

    @PostMapping("/update/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute BorrowingTransactionModel transaction) {
        transaction.setId(id);
        transactionService.saveTransaction(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}
