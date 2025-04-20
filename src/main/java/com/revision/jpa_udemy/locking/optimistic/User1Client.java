package com.revision.jpa_udemy.locking.optimistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User1Client implements Runnable{

	@Autowired
	private GuideService guideService;
	
	@Override
	public void run() {
//		un-comment for optimistic locking testing
//		Guide guide = guideService.findGuideById(2L);
//		guide.setSalary(4000);
//		try {
//			guideService.updateGuide(guide);
//		}catch(Exception ex) {
//			System.out.println("Row was updated or deleted by another transaction : "+ex);
//		}
		
//		pessimistic locking testing
		guideService.getNameAndSalaryOfAllGuides();
	}

}
