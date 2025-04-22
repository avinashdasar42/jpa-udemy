package com.revision.jpa_udemy.relationships.manyTomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CinemaService {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public void saveMoviesAndActors() {
		Actor actor1 = new Actor("Chris Hemsworth");
		Actor actor2 = new Actor("Chris Evans");
		
		Movie movie1 = new Movie("Avengers: Infinity war");
		Movie movie2= new Movie("Thor: Ragnorak");
				
		actor1.addMovie(movie1);
		actor1.addMovie(movie2);
		
		actor2.addMovie(movie2);
		
		actorRepository.save(actor1);
		actorRepository.save(actor2);
		
		
	}
}
