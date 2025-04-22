package com.revision.jpa_udemy.locking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GuideService {
	
	@Autowired
	private GuideRepository guideRepository;
	
//	@Transactional
//	public Guide findGuideById(Long id) {
//		return guideRepository.findById(id).get();
//	}
//	
//	@Transactional
//	public void updateGuide(Guide guide) {
//		guideRepository.save(guide);
//	}
	
	@Transactional
	public void getNameAndSalaryOfAllGuides() {		
		List<Object[]> result = guideRepository.getNameAndSalaryOfAllGuides();		
		for (Object[] obj : result) {
			System.out.println("Name: "+obj[0]+"\t\t, Salary: "+obj[1]);
		}
		
		System.out.println("******calculate total salary of all guides : "+guideRepository.calculateTotalSalary()+"******");
	}
	
	@Transactional
	public void raiseSalary(Long id, double newSalary) {
		Guide guide = guideRepository.findById(id).get();
		guide.setSalary(newSalary);
	}

}
