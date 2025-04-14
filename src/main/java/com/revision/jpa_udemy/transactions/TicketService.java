package com.revision.jpa_udemy.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	// though payment failed, ticket no is getting allocating/saved in database which is wrong
	public void bookTicketWithoutTransactional(Ticket ticket) {
		ticketRepository.save(ticket);// allocating seat no to customer
		throw new RuntimeException("Payment Failure!!"); // payment fails
	}
	
	//this will roll back actions performed in this method whenever runtime exception happened
	@Transactional
	public void bookTicketWithTransactional(Ticket ticket) {
		ticketRepository.save(ticket);// allocating seat no to customer
		throw new RuntimeException("Payment Failure!!"); // payment fails
	}

}
