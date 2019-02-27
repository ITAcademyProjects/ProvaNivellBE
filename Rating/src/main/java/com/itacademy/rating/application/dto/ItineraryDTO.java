package com.itacademy.rating.application.dto;

import com.google.gson.annotations.Expose;
import com.itacademy.rating.domain.Itinerary;

public class ItineraryDTO {

	@Expose
	private String code;

	public ItineraryDTO(Itinerary itinerary) {
		this.code = itinerary.getId();
	}
	
}
