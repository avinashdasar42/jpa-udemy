package com.revision.jpa_udemy.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.revision.jpa_udemy.models.Student;

//when any repository extends Repository interface. It is usually referred for custom repository
//We can mentioned our custom queries. Dynamically using Proxy JPA framework will create queries at run time
public interface StudentRepository extends JpaRepository<Student, Long>{

	Student save(Student student);
	
	Optional<Student> findByEnrollmentId(String enrollmentId);
	
	List<Student> findByEnrollmentIdStartingWith(String enrollmentId);
	
	List<Student> findByEnrollmentIdStartingWithAndNameContaining(String enrollmentId, String name);
	
	@Query("select s from students s where s.enrollmentId=:enrollmentId")
	Optional<Student> findByEnrollmentIdUsingJPQL(String enrollmentId);
}
