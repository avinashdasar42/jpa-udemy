package com.revision.jpa_udemy.transactions;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String source;
	private String destination;
	private Double fare;
	private Date date;
	
	public Ticket() {}
	
	public Ticket(String source, String destination, Double fare, Date date) {
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.date = date;
	}
	
	
}
