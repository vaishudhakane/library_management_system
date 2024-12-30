package com.LibraryManagement.LibraryManagementSystem.Repository;

import java.util.List;

//import com.example.library.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagement.LibraryManagementSystem.Model.PublisherModel;

public interface PublisherRepository extends JpaRepository<PublisherModel, Long> {

	
}
