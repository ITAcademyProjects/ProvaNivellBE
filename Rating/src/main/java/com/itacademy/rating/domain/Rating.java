package com.itacademy.rating.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;

import com.itacademy.rating.application.dto.RatingDTO;

@Entity(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotNull(message = "Must set 'rating' attribute")
	private Integer rating;

	private String comment;

	@ManyToOne
	private Video video;

	public Rating() {
	}

	public Rating(RatingDTO ratingDTO, Video video) {
		this.rating = ratingDTO.getRating();
		this.comment = ratingDTO.getComment();
		this.video = video;
	}

	public int getValoration() {
		return rating;
	}

	public String getComment() {
		return comment;
	}

}