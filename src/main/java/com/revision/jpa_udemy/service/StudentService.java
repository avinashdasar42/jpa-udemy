package com.revision.jpa_udemy.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;

import com.revision.jpa_udemy.models.Student;
import com.revision.jpa_udemy.repos.StudentRepository;

@Component
public class StudentService implements ApplicationRunner{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Student student1 = new Student();
		student1.setName("Alex");
		student1.setEnrollmentId("FY20250001");
		Student student2 = new Student();
		student2.setName("Jane");
		student2.setEnrollmentId("FY20250002");
		
		//save 
		studentRepository.save(student1);
		studentRepository.save(student2);
		
		//Query By Names
		//findByEnrollmentId
		String searchString = "FY20250002";
		Optional<Student> studentByEnrollmentId = studentRepository.findByEnrollmentId(searchString);
		if(studentByEnrollmentId.isPresent()) {
			System.out.println(studentByEnrollmentId.get());
		}else {
			System.out.println("not found !!!!!");
		}
		
		String startsWith = "FY2025";
		List<Student> studentByEnrollmentIdStartsWith = studentRepository.findByEnrollmentIdStartingWith(startsWith);
		System.out.println(studentByEnrollmentIdStartsWith.size() == 2 ? "Success!!!":"Error !!!");
		
		List<Student> studentsResult = studentRepository.findByEnrollmentIdStartingWithAndNameContaining(startsWith,"Al");
		System.out.println(studentsResult.size() == 1? "Success !!":"Error!!");
		for (Student student : studentsResult) {
			System.out.println(student);
		}
		
		//Query By Example
		Student student3 = new Student();
		student3.setName("Alexa");
		student3.setEnrollmentId("FY20250003");
		Student student4 = new Student();
		student4.setName("John");
		student4.setEnrollmentId("FY20250004");
		studentRepository.save(student3);
		studentRepository.save(student4);
		
		System.out.println("------Query By Example -------");
		Example<Student> studentByExample = Example.of(student4);
		List<Student> students = studentRepository.findAll(studentByExample);
		students.forEach(student -> System.out.println(student));
			
		System.out.println("------Query By Example Matcher -------");
		Student student = new Student();
		student.setEnrollmentId("FY2025");
		ExampleMatcher withStringMatcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.STARTING);
		Example<Student> example = Example.of(student, withStringMatcher);
		List<Student> all = studentRepository.findAll(example);
		all.forEach(aStudent -> System.out.println(aStudent));
		
		System.out.println("-------------JPQL-------------");
		Optional<Student> studentByJPQL = studentRepository.findByEnrollmentIdUsingJPQL("FY20250003");
		if(studentByJPQL.isPresent()) {
			System.out.println(studentByJPQL.get());
		}
	}

}
