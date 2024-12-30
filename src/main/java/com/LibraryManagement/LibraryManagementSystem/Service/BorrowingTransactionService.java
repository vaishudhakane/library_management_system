package com.LibraryManagement.LibraryManagementSystem.Service;


import org.springframework.stereotype.Service;

import com.LibraryManagement.LibraryManagementSystem.Model.BorrowingTransactionModel;
import com.LibraryManagement.LibraryManagementSystem.Repository.BorrowingTransactionRepository;

import java.util.List;

@Service
public class BorrowingTransactionService {

    private final BorrowingTransactionRepository transactionRepository;

    public BorrowingTransactionService(BorrowingTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<BorrowingTransactionModel> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public BorrowingTransactionModel saveTransaction(BorrowingTransactionModel transaction) {
        return transactionRepository.save(transaction);
    }

    public BorrowingTransactionModel getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid transaction ID: " + id));
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

	
}
