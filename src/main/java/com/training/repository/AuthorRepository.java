package com.training.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.training.model.Author;

@Repository
public class AuthorRepository {

	private List<Author> authors = new ArrayList<>();

	@PostConstruct
	private void init() {
		authors.add(new Author(1, "Josh", "Long"));
		authors.add(new Author(2, "Mark", "Heckler"));
		authors.add(new Author(3, "Greg", "Turnquist"));
	}

	public List<Author> findAll() {
		return authors;
	}

	public Author findById(int id) {
		return authors.stream().filter(author -> author.getId() == id).findFirst()
				.orElseThrow(() -> new RuntimeException("Author not found"));
	}

	public Author findByName(String name) {
		return authors.stream().filter(author -> author.getFullName().equals(name)).findFirst()
				.orElseThrow(() -> new RuntimeException("Author not found"));
	}
}