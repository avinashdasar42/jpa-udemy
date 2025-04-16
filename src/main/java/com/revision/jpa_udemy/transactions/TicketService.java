package com.revision.jpa_udemy.transactions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	// though payment failed, ticket no is getting allocating/saved in database which is wrong
	public void bookTicketWithoutTransactional(Ticket ticket) {
		ticketRepository.save(ticket);// allocating seat no to customer
		throw new RuntimeException("Payment Failure!!"); // payment fails
	}
	
	//this will roll back actions performed in this method whenever runtime exception happened
	@Transactional
	public void bookTicketWithTransactional(Ticket ticket) {
		ticketRepository.save(ticket);// allocating seat no to customer
//		throw new RuntimeException("Payment Failure!!"); // payment fails
	}
	
	@Transactional
	public void someTask() throws InterruptedException {
		Thread.sleep(10000);
		System.out.println("Before call");
		Ticket ticket = ticketRepository.findById(1L).get();
		
		Thread.sleep(10000);
		System.out.println("After call");
	}

	// Here two operations are performed under transactional
	// By Default auto-commit is enabled
	// even though of them failed other ill persist
	// Hence in such scenario auto-commit should be disabled
	// we can disabled it by adding few properties in application.properties file
	@Transactional
	public void bookRide(Ticket ticket) {
		
		//save ticket
		Ticket newTicket = ticketRepository.save(ticket);
		
		//save payment
		Payment payment = new Payment();
		payment.setAmount(ticket.getFare());
		paymentRepository.save(payment);
		
	}

	@Transactional
	public void persistTicket() {
		Ticket ticket1 = new Ticket("Pune","Mumbai",500.0,new Date());
		Ticket ticket2 = new Ticket("Pune","Delhi",1500.0,new Date());
		ticketRepository.save(ticket1);
		ticketRepository.save(ticket2);
	}

	//By Default readOnly=false i.e read-write is ON
	@Transactional
	public void fetchWithReadWriteTransaction() {
		Ticket ticket = ticketRepository.findById(1L).get();
		ticket.setFare(5000.00);
	}
	
	@Transactional(readOnly = true)
	public void fetchWithReadOnlyTransaction() {
		Ticket ticket = ticketRepository.findById(2L).get();
		ticket.setFare(2000.00);
	}

}
