package com.revision.jpa_udemy.propogation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemClient implements ApplicationRunner{
	
	@Autowired
	private ItemService itemService;

	//uncomment if want to run
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Item mobile = new Item("iQOO",25000);
//		itemService.saveItem(mobile);
	}

}
