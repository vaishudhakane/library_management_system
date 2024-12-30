package com.LibraryManagement.LibraryManagementSystem.Repository;

//import com.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.LibraryManagementSystem.Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
