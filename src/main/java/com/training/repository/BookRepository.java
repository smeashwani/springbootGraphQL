package com.training.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.Book;
import com.training.model.BookInput;
import com.training.model.Rating;

@Repository
public class BookRepository {

	@Autowired
	private AuthorRepository authorRepository;
	
	private List<Book> books = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		books.add(new Book(1, "Spring", 484, Rating.FIVE_STARS, authorRepository.findByName("Josh Long")));
		books.add(new Book(2, "Spring Boot", 328, Rating.FIVE_STARS, authorRepository.findByName("Mark Heckler")));
		books.add(new Book(3, "Hacking", 392, Rating.FIVE_STARS, authorRepository.findByName("Greg Turnquist")));
	}

	public List<Book> findAll() {
		return books;
	}

	public Book findOne(Integer id) {
		return books.stream().filter(book -> book.getId() == id).findFirst()
				.orElseThrow(() -> new RuntimeException("Book not found"));
	}
	
	public Book addBook(BookInput book) {
		Book temp = new Book(books.size()+1,book.getTitle(),book.getPages(), null,null);
		books.add(temp);
		return temp;
	}
}
