package com.revision.jpa_udemy.specifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SpecificationClient implements ApplicationRunner{
	
	@Autowired
	BookService bookService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Book b1 = new Book("Let us C","John Doe","2002");
		Book b2 = new Book("Python Basics","Jane Snow","2013");
		Book b3 = new Book("Devops for Beginners","Will Jackman","2019");
		Book b4 = new Book("Python for Senior Developers","Will Peterson","2016");
		Book b5 = new Book("Docker Fundamentals","Will Peterson","2016");
		
		bookService.saveBooks(b1);
		bookService.saveBooks(b2);
		bookService.saveBooks(b3);
		bookService.saveBooks(b4);
		bookService.saveBooks(b5);
		
//		List<Book> bookFound = bookService.findBookByName("Let us C");
//		List<Book> bookFound = bookService.findAllBooksNameStartingWith("Python");
		List<Book> bookFound = bookService.findBookWrittenByAndPublishedIn("Will Peterson","2016");
		
		System.out.println("***Books Found **** "+ bookFound);
		
	}

}
