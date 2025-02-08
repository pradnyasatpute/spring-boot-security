package com.ps.moviemanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.moviemanagement.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
}
