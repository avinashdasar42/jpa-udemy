package com.revision.jpa_udemy.specifications;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String author;
	private String publishedYear;
	
	public Book() {}
	
	public Book(String name, String author, String year) {
		this.name=name;
		this.author=author;
		this.publishedYear=year;
	}
}
