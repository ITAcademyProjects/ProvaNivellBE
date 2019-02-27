package com.itacademy.rating.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rating.domain.Itinerary;
import com.itacademy.rating.domain.Video;

@Repository
public interface HelperVideoRepository extends CrudRepository<Video, Integer> {
	List<Video> findByItinerary(Itinerary itinerary);
}
