package com.itacademy.rating.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itacademy.rating.domain.Itinerary;
import com.itacademy.rating.repositories.HelperItinerayRepository;

@Controller
public class ItineraryController {

	@Autowired
	HelperItinerayRepository itineraryRepository;

	public Itinerary getOrCreateItinerary(String itineraryCode) throws Exception {
		Itinerary itinerary = itineraryRepository.findById(itineraryCode).orElse(null);
		if (itinerary == null) {
			itinerary = new Itinerary(itineraryCode);
			itineraryRepository.save(itinerary);
		}
		return itinerary;
	}

	public void saveItinerary(Itinerary itinerary) {
		itineraryRepository.save(itinerary);
	}
}
