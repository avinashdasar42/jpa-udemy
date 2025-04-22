package com.revision.jpa_udemy.relationships.ManyToOne;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long>{

}
