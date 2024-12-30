package com.LibraryManagement.LibraryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
//import com.example.library.model.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.LibraryManagementSystem.Model.BorrowingTransactionModel;

public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransactionModel, Long> {
	
}