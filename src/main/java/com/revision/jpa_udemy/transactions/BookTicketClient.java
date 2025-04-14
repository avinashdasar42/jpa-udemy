package com.revision.jpa_udemy.transactions;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BookTicketClient implements ApplicationRunner{

	@Autowired
	private TicketService ticketService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setSource("Pune");
		ticket.setDestination("Mumbai");
		ticket.setDate(new Date());
//		ticketService.bookTicketWithoutTransactional(ticket);
		ticketService.bookTicketWithTransactional(ticket);
	}

}
