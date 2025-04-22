package com.revision.jpa_udemy.relationships.manyTomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ManyToManyClient implements ApplicationRunner{
	
	@Autowired
	private CinemaService cinemaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		cinemaService.saveMoviesAndActors();
		
	}

}
