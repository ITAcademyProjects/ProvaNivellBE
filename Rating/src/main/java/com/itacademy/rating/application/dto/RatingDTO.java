package com.itacademy.rating.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.rating.domain.Rating;

public class RatingDTO {
	@Expose
	private int valoration;
	@Expose
	private String comment;

	public RatingDTO(int rating, String comment) {
		this.valoration = rating;
		this.comment = comment;
	}

	public RatingDTO(Rating rate) {
		this.valoration = rate.getValoration();
		this.comment = rate.getComment();
	}

	public int getRating() {
		return valoration;
	}

	public String getComment() {
		return comment;
	}
}
