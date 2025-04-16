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
		ticketService.persistTicket();
//		ticketService.bookTicketWithoutTransactional(ticket);
//		ticketService.bookTicketWithTransactional(ticket);
//		ticketService.someTask();
//		ticketService.bookRide(ticket);
		
//		ticketService.fetchWithReadWriteTransaction();
		ticketService.fetchWithReadOnlyTransaction();
	}
 
}
