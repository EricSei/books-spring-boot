package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognixia.jump.model.Book;
import com.cognixia.jump.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	//book list
	public List<Book> getAllBooks() {
		
		return repo.findAll();
	}
	
	//read
	public Optional<Book> getBookById(int id){
		Optional<Book> found = repo.findById(id);
		
		return found;
	}
	
	//create
	public Book createBook(Book newBook) {
		newBook.setId(null);
		Book createdBook = repo.save(newBook);
		return createdBook;
	}
	
	//delete
	public boolean deleteBookById(int id) {
		 if(repo.existsById(id)) {
			 repo.deleteById(id);
			 return true;
		 }
		 return false;
	}
	
	//update
	public Book updateBook(Book newBook) {
		
		if(repo.existsById(newBook.getId())) {
			Book updated = repo.save(newBook);
			return updated;
		}
		
		return null;
	}
	
	//getBookByAuthor
	public List<Book> getByAuthor(String author){
//		return repo.findByAuthor(author);
		return repo.fromSameAuthor(author);
		
	}
	
	//getBookByAuthor
	public List<Book> getByTitle(String title){
		return repo.findByTitle(title);
		
	}
	
	
	
	
	
}
