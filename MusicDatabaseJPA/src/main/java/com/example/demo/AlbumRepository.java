package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	List<Album> findByArtistOrderByReleaseyear(String artist);
	
	List<Album> findByReleaseyearBetween(String releaseYear1, String releaseYear2);
	
	List<Album> findByGenreAndReleaseyearGreaterThan(String genre, String releaseyear);
	
	long countByArtist(String artist);

}
