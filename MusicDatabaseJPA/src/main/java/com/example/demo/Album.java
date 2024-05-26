package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long id;
	
	private String artist;
	private String albumname;
	private String releaseyear;
	private String genre;
	
	public Album() {
	}

	
	public Album(String artist, String albumname, String releaseyear, String genre) {
		super();
		this.artist = artist;
		this.albumname = albumname;
		this.releaseyear = releaseyear;
		this.genre = genre;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	public String getReleaseyear() {
		return releaseyear;
	}
	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
