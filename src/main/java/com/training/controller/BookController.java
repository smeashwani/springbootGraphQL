package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.training.model.Book;
import com.training.model.BookInput;
import com.training.repository.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@SchemaMapping(typeName = "Query",value = "allBooks")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
	
	@QueryMapping
	public Book find(@Argument Integer id) {
		return bookRepository.findOne(id);
	}
	
	@MutationMapping
	public Book addBook(@Argument BookInput book) {
		return bookRepository.addBook(book);
	}
}
