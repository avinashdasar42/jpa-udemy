package com.revision.jpa_udemy.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class BookSpecification {
	
	public static Specification<Book> booksPublishedIn(String year){
		return (root, query, builder) -> builder.equal(root.get("publishedYear"), year);		
	}
	
	public static Specification<Book> hasTitle(String title){
		return (root, query, builder) -> builder.equal(root.get("name"), title);
	}
	
	public static Specification<Book> hasTitleStartsWith(String nameStartsWith){
		return (root, query, builder) -> builder.like(root.get("name"), nameStartsWith + "%");
	}
	
	public static Specification<Book> hasAuthor(String author){
		return (root, query, builder) -> builder.equal(root.get("author"), author);
	}

}
