package com.revision.jpa_udemy.propogation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoggerService {
	
	@Autowired
	private LoggerRepository loggerRepository;
	
	@Transactional
	public void logMessageWithTxn(Message msg) {
		loggerRepository.save(msg);
		throw new RuntimeException("Logging Failed in method with transaction annotation!!");
	}

	public void logMessageWithoutTxn(Message msg) {
		loggerRepository.save(msg);
		throw new RuntimeException("Logging Failed in method without transaction annotation!!");
	}

}
