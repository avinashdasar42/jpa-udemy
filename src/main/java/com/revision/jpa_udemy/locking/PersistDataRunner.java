package com.revision.jpa_udemy.locking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class PersistDataRunner implements ApplicationRunner {

	@Autowired
	private GuideRepository guideRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Guide guide1 = new Guide("FY20251001","John Doe",2000);
		Guide guide2 = new Guide("FY20251002","Jane Doe",1000);
		Guide guide3 = new Guide("FY20251002","Jimmy Doe",8000);
		
		guideRepository.save(guide1);
		guideRepository.save(guide2);
		guideRepository.save(guide3);
	}
	
}
