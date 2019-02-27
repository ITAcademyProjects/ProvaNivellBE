package com.itacademy.rating.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itacademy.rating.domain.Rating;
import com.itacademy.rating.domain.Video;

@Repository
public interface HelperRatingRepository extends CrudRepository<Rating, Integer> {

	List<Rating> findByVideo(Video video);
}
