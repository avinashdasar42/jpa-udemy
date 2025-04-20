package com.revision.jpa_udemy.propogation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private LoggerService loggerService;
	
	// by default, propagation type is REQUIRED
	// that means if transaction is there use it otherwise create new transaction
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveItem(Item item) {
		Item savedItem = itemRepository.save(item);
		Message message = new Message("item : "+savedItem.getName()+" is saved with id: "+savedItem.getId());
		loggerService.logMessageWithTxn(message);
//		loggerService.logMessageWithoutTxn(message);
	}

	

}
