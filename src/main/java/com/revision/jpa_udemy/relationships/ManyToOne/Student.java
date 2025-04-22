package com.revision.jpa_udemy.relationships.ManyToOne;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String enrollmentId;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	
	public Student() {}
	public Student(String enrollmentId, String name, Tutor tutor) {
		this.enrollmentId=enrollmentId;
		this.name=name;
		this.tutor=tutor;
	}
	
	public Student(String enrollmentId, String name) {
		this.enrollmentId=enrollmentId;
		this.name=name;
	}
	
	
}
