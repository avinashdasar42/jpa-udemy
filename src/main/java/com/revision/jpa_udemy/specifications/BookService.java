package com.revision.jpa_udemy.specifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public List<Book> findBookWrittenByAndPublishedIn(String author, String year) {
		Specification<Book> specResult = BookSpecification.hasAuthor(author).and(BookSpecification.booksPublishedIn(year));
		return bookRepository.findAll(specResult);
	}
		
	@Transactional
	public List<Book> findBookByName(String name){
		Specification<Book> hasTitle = BookSpecification.hasTitle(name);
		return bookRepository.findAll(hasTitle);
	}
	
	@Transactional
	public List<Book> findAllBooksNameStartingWith(String name){
		Specification<Book> hasTitleStartsWith = BookSpecification.hasTitleStartsWith(name);
		return bookRepository.findAll(hasTitleStartsWith);
	}
	
	@Transactional
	public void saveBooks(Book book) {
		bookRepository.save(book);
	}

}
