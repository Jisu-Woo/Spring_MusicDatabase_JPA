package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//already @ResponseBody
@RestController
public class AlbumRestController {
	
	//loosely coupled wiring
	@Autowired
	private AlbumRepository repo;
	
	//Add new Album
	@PostMapping(value="/add", consumes = "application/json")
	public String addAlbum(@RequestBody Album a) {
		System.out.println("Received an album: "+a.getAlbumname());
		repo.save(a);
		return "Received an album!"; // boolean converts to String by ""
	}
	
	//Edit an existing Album (existsById())
	@PostMapping(value="/edit", consumes = "application/json")
	public String editAlbum(@RequestBody Album a) {
		if(repo.existsById(a.getId())) {
			System.out.println("Edit an album: "+a.getAlbumname());
			repo.save(a);
			return "edit an album!";
		}
		else {
			System.out.println("Not exist.");
			return "not exist!";
		}
	}
	
	//Delete one album
	@GetMapping(value="/deleteone/{id}")
	public String deleteOneAlbum(@PathVariable long id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "Delete Complete";
		}
		else {
			System.out.println("Not exist.");
			return "Not exist.";
		}
	}
	
	//Delete all albums
	@GetMapping(value="/deleteall")
	public String deleteAll() {
		repo.deleteAll();
		return "Delete All";
	}
	
	
	//Find all albums
	@GetMapping(value="/all", produces="application/json")
	public List<Album> findAll() {
		return repo.findAll();
	}
	
	//Find albums by artist, order by releaseyear
	@GetMapping(value="/find/artist/{artist}", produces = "application/json")
	public List<Album> findByArtist(@PathVariable String artist) {
		
		return repo.findByArtistOrderByReleaseyear(artist);

	}
	
	//Find albums between two releaseyears
	@GetMapping(value="/find/twoyears/{releaseyear1}/{releaseyear2}", produces = "application/json")
	public List<Album> findByTwoYears(@PathVariable String releaseyear1, @PathVariable String releaseyear2) {
		
		return repo.findByReleaseyearBetween(releaseyear1, releaseyear2);
	}
	
	
	//Find albums by genre and release year greater than given year
	@GetMapping(value="/find/genreandyear/{genre}/{releaseyear}", produces = "application/json")
	public List<Album> findByGenreAndYear(@PathVariable String genre, @PathVariable String releaseyear) {
		
		return repo.findByGenreAndReleaseyearGreaterThan(genre, releaseyear);
	}
	
	
	//Count the number of albums by artist
	@GetMapping(value="/count/{artist}")
	public String countByArtist(@PathVariable String artist) {
		
		return "Number of albums: "+repo.countByArtist(artist);

	}

}
