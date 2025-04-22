package com.revision.jpa_udemy.relationships.ManyToOne;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String subject;
	
	@OneToMany(mappedBy = "tutor") //by default oneTomany is LAZY
	private Set<Student> students = new HashSet<>();
	public Tutor() {}
	public Tutor(String name, String subject) {
		this.name=name;
		this.subject=subject;
	}
	
}
