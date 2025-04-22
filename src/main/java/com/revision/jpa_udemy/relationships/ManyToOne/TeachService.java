package com.revision.jpa_udemy.relationships.ManyToOne;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeachService {

	@Autowired
	private IStudentRepository studentRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
//	save data via owners end i.e Student >> save student , tutor will be saved automatically
	@Transactional
	public void saveStudentAndTutor() {
		Tutor tutor1 = new Tutor("Matt Fraser","Maths");
		Student student1 = new Student("FY20251001","John Doe", tutor1);
		
		Tutor tutor2 = new Tutor("Nick Thomas","English");
		Student student2 = new Student("FY20251002","Patrick Johnson", tutor2);
		
		Student student3 = new Student("FY20251003","Jane Doe", tutor1);
		
//		tutorRepository.save(tutor); when cascade it set, we don't need to save tutor separately
//		when we use cascadeTyoe as persist, it will save associated entity as well
		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
	}
	
	@Transactional
	public void findStudentById() {
		Student student = studentRepository.findById(1L).get();
		System.out.println("************Student: "+student+"**********************");// by default fetch type for @manyToOne is eager
//		 hence tutor will also be pulled from DB, we can use fetch type as LAZY to change this behavior
	}
	
	@Transactional
	public void updateStudentAndTutor() {
		
		Student student = studentRepository.findById(1L).get();
		Tutor tutor = student.getTutor();
		
		student.setEnrollmentId("FY20241001");
//		when we update associated entity we have to use cascadeType as merge
		tutor.setSubject("Programming");
		
		studentRepository.save(student);
	}
	
//	When finding Students via Tutor Id i.e, inverse end
//	@Transactional
//	public void findStudentsViaTutor() {
//		Tutor tutor = tutorRepository.findById(1L).get();
//		System.out.println("*****Tutor: "+tutor+"******");
//		Set <Student> students = tutor.getStudents();
//		int size = students.size();
//		System.out.println("*****Tutor: "+tutor+"******");
//	}
}
