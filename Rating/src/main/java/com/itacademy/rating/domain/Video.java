package com.itacademy.rating.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.itacademy.rating.application.dto.VideoDTO;

@Entity
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	@ManyToOne
	private Itinerary itinerary;

	public Video() {
	}

	public Video(VideoDTO videoDTO, Itinerary itinerary) throws Exception {
		if (videoDTO == null || itinerary == null)
			throw new Exception("Not empty/null Name and Itinerary are required");
		this.name = videoDTO.getName();
		this.itinerary = itinerary;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}