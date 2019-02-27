package com.itacademy.rating.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="itineraries")
public class Itinerary {
	public static final String BE = "BE";
	public static final String FE = "FE";
	public static final String AD = "AD";

	public static final List<String> ITINERARY_CODES = Arrays.asList(BE, FE, AD);

	@Id
	private String code;

	public Itinerary() {
	}

	public Itinerary(String itineraryCode) throws Exception {
		if (!ITINERARY_CODES.contains(itineraryCode))
			throw new Exception("Wrong Itinerary code");

		this.code = itineraryCode;

	}

	public String getId() {
		return code;
	}
}