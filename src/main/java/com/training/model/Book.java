package com.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer id;
	private String title;
	private Integer pages;
	private Rating rating;
	private Author author;
}

