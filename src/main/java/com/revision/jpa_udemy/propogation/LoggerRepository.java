package com.revision.jpa_udemy.propogation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Message, Long>{

}
