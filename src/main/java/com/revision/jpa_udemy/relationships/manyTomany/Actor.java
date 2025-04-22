package com.revision.jpa_udemy.relationships.manyTomany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "actors")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany(mappedBy = "actors", cascade = {CascadeType.PERSIST})
	private Set<Movie> movies = new HashSet<>();
	
	public Actor() {}
	public Actor(String name) {
		this.name=name;
	}
	
	
	//These are helper methods which helps to save data by both side of the realtionship
	public void addMovie(Movie movie) {
		this.movies.add(movie);
		movie.getActors().add(this);
	}
	
	public void removeMovie(Movie movie) {
		this.movies.remove(movie);
		movie.getActors().remove(this);
	}
}
