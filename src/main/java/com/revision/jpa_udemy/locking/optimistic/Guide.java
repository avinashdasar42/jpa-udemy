package com.revision.jpa_udemy.locking.optimistic;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

@Entity
@Data
public class Guide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String staffId;
	private String name;
	private double salary;
	
//	 this will apply optimistic locking mechanism 
//	@Version
//	private Integer version;
	
	public Guide() {}
	
	public Guide(String staffId, String name, double salary) {
		this.staffId=staffId;
		this.name=name;
		this.salary=salary;
	}

}
