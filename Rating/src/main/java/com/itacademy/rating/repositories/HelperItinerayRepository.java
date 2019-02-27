package com.itacademy.rating.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rating.domain.Itinerary;

@Repository
public interface HelperItinerayRepository extends CrudRepository<Itinerary, String> {
}
