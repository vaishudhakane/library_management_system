package com.LibraryManagement.LibraryManagementSystem.Service;


import org.springframework.stereotype.Service;

import com.LibraryManagement.LibraryManagementSystem.Model.UserModel;
import com.LibraryManagement.LibraryManagementSystem.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    public UserModel getUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
    }
    public UserModel updateUser(Long id, UserModel user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Invalid user ID: " + id);
        }
    }
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid user ID: " + id);
        }
    }
}
