package com.revision.jpa_udemy.locking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.LockModeType;

public interface GuideRepository extends JpaRepository<Guide, Long>{
	
	//apply pessimistic lock mechanism
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Query("select guide.name, guide.salary from Guide guide")
	List<Object[]> getNameAndSalaryOfAllGuides();
	
	@Query("select sum(guide.salary) from Guide guide")
	Long calculateTotalSalary();

}
