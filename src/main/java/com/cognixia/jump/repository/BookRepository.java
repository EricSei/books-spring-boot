package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer > {
	
	public List<Book> findByAuthor(String author);
	
	@Query("select s from Book s where s.author = ?1 ")
	public List<Book> fromSameAuthor(String author);
	
	public List<Book> findByTitle(String title);
}
