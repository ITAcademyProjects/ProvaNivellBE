package com.itacademy.rating.application.dto;

import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;
import com.itacademy.rating.domain.Itinerary;
import com.itacademy.rating.domain.Video;

public class VideoDTO {
	@Expose
	private int id;
	@Expose
	private String name;

	@ManyToOne(targetEntity = Itinerary.class)
	private Itinerary itinerary;

	public VideoDTO(Video exercise) throws Exception {
		if (exercise == null)
			throw new Exception();
		this.id = exercise.getId();
		this.name = exercise.getName();
	}

	public String getName() {
		return this.name;
	}

}
