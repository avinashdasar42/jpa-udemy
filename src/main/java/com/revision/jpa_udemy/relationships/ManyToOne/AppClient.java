package com.revision.jpa_udemy.relationships.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppClient implements ApplicationRunner{
	
	@Autowired
	private TeachService teachService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
//		teachService.saveStudentAndTutor();
//		teachService.findStudentById();
//		teachService.updateStudentAndTutor();
//		teachService.findStudentsViaTutor();
	}

}
