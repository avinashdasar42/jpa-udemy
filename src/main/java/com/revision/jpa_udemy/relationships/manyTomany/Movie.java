package com.revision.jpa_udemy.relationships.manyTomany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToMany
	@JoinTable(
			name = "movies_actors",
			joinColumns = {@JoinColumn(name="movie_id")},
			inverseJoinColumns = {@JoinColumn(name="actor_id")}
	)
	private Set<Actor> actors = new HashSet<>();
	
	public Movie() {}
	
	public Movie(String title) {
		this.title=title;
	}
	
}
