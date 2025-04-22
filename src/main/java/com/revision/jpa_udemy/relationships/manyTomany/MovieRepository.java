package com.revision.jpa_udemy.relationships.manyTomany;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
