package com.revision.jpa_udemy.propogation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logMessage;
	
	public Message() {}
	
	public Message(String msg) {
		this.logMessage = msg;
	}
}
