package com.cognixia.jump.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set up auto incrementing
	private Integer id;
	
	private String title;
	private String author;
	
	@Column(unique = true, nullable = false)
	private String isbn;
	
	private String description;
	private LocalDate releasedDate;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	

	public Book() {
		
	}
	
//	public Book(String title, String author, String isbn, String description, LocalDate releasedDate) {
//		super();
//		this.title = title;
//		this.author = author;
//		this.isbn = isbn;
//		this.description = description;
//		this.releasedDate = releasedDate;
//	}
}
