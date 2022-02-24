package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Book;
import com.cognixia.jump.service.BookService;

@RequestMapping("/api")
@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public List<Book> getAllBook(){
		return service.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		
			Optional<Book> found = service.getBookById(id);
				
			if(found.isEmpty()) {
				return ResponseEntity
						.status(404)
						.body("Book Not found");
			}
			
			Book book = found.get();
			
			return ResponseEntity
					.status(200)
					.body(book);
		
	}
	
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody Book book){
		Book createdBook = service.createBook(book);
		
		return ResponseEntity
				.status(201)
				.body(createdBook);
	}
	
	@DeleteMapping("/books/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable int id){
		
		if(service.deleteBookById(id)) {
			return ResponseEntity
					.status(201)
					.body(id + " was deleted.");
		}
		
		return ResponseEntity
				.status(401)
				.body(id + "was not found, or can't be deleted.");
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<?> updateBook(@RequestBody Book newBook){
		Book updated = service.updateBook(newBook);
		if(updated == null) {
			return ResponseEntity
					.status(401)
					.body(newBook.getId() + " cant be found or updated.");
		}
		return ResponseEntity
				.status(201)
				.body(updated);
	}
	
	@GetMapping("/books/author/{author}")
	public List<Book> findByAuthor(@PathVariable String author){
		
		return service.getByAuthor(author);
	
		
	}
	
	//get book by author via Param
	@GetMapping("/books/author")
	public List<Book> findByAuthorName(@PathParam(value="author") String author){
		
		return service.getByAuthor(author);
	
		
	}
	
	@GetMapping("/book/title/{title}")
	public List<Book> findByTitle(@PathVariable String title){
		
		return service.getByTitle(title);
		
	}
	
		
}
