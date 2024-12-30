package com.LibraryManagement.LibraryManagementSystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "books")
public class BookModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   //Newly added for transaction
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    private String title;
    private String author;
    private String status;

    @ManyToOne
    @JoinColumn(name = "publisher_id") // Foreign key in the books table
    private PublisherModel publisher;

    // Getters and Setters
    public PublisherModel getPublisher() {
        return publisher;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		this.id=id2;
	}
}
