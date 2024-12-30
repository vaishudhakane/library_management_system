package com.LibraryManagement.LibraryManagementSystem.Service;



import org.springframework.stereotype.Service;

import com.LibraryManagement.LibraryManagementSystem.Model.PublisherModel;
import com.LibraryManagement.LibraryManagementSystem.Repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherModel> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherModel savePublisher(PublisherModel publisher) {
        return publisherRepository.save(publisher);
    }

    public PublisherModel getPublisherById(Long id) {
        return publisherRepository.findById(id)
                                   .orElseThrow(() -> new IllegalArgumentException("Invalid publisher ID: " + id));
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
	
}
