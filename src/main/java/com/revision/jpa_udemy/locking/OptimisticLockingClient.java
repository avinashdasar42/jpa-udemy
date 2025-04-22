package com.revision.jpa_udemy.locking;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class OptimisticLockingClient implements ApplicationRunner{

	@Autowired
	private User1Client user1Client;
	
	@Autowired
	private User2Client user2Client;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// Here 2 threads are trying to access & update same data from db
		// if we don't use optimistic locking, we will lost updated and last commit will win
		// it means one of them override others changes and update will be lost
		
		//uncomment to run it
//		ExecutorService executor = Executors.newFixedThreadPool(2);
//		executor.execute(user1Client);
//		executor.execute(user2Client);
		
//		executor.shutdown();
	}

}
