package com.revision.jpa_udemy.propogation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int cost;
	
	public Item() {}
	
	public Item(String name, int cost) {
		this.name=name;
		this.cost=cost;
	}
}
