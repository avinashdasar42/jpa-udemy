package com.revision.jpa_udemy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revision.jpa_udemy.transactions.Ticket;
import com.revision.jpa_udemy.transactions.TicketRepository;
import com.revision.jpa_udemy.transactions.TicketService;

@SpringBootTest
class BookTicketClientTest {
	@Autowired
	TicketService ticketService;

	@Autowired
	TicketRepository ticketRepository;

	@Test
	void testBookingTicketWithTransactional() {
		try {
			Ticket ticket = new Ticket();
			ticket.setSource("Pune");
			ticket.setDestination("Mumbai");

			ticketService.bookTicketWithTransactional(ticket);
		}catch(RuntimeException ex) {
			System.out.println("Message: "+ex.getMessage());
		}finally {
			assertTrue(ticketRepository.findAll().size()==0);
		}

	}

	@Test
	void testBookingTicketWithoutTransactional() {
		try {
			Ticket ticket = new Ticket();
			ticket.setSource("Pune");
			ticket.setDestination("Mumbai");

			ticketService.bookTicketWithoutTransactional(ticket);
		}catch(Exception ex) {
			System.out.println("Message: "+ex.getMessage());
		}finally {
			assertTrue(ticketRepository.findAll().size() != 0);
		}

	}

}
