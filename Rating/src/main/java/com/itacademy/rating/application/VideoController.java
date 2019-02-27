package com.itacademy.rating.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itacademy.rating.application.dto.RatingDTO;
import com.itacademy.rating.application.dto.VideoDTO;
import com.itacademy.rating.domain.Itinerary;
import com.itacademy.rating.domain.Rating;
import com.itacademy.rating.domain.Video;
import com.itacademy.rating.repositories.HelperRatingRepository;
import com.itacademy.rating.repositories.HelperVideoRepository;

@Controller
public class VideoController {

	@Autowired
	ItineraryController controler;
	@Autowired
	HelperVideoRepository videoRepository;
	@Autowired
	HelperRatingRepository ratingRepository;

	public List<VideoDTO> getVideos(String itineraryCode) throws Exception {

		Itinerary itinerary = controler.getOrCreateItinerary(itineraryCode);
		List<Video> videos = videoRepository.findByItinerary(itinerary);

		List<VideoDTO> result = new ArrayList<>();

		for (Video video : videos) {
			result.add(new VideoDTO(video));
		}
		return result;
	}

	public void rateVideo(RatingDTO ratingDTO, String itineraryCode, int videoId) throws Exception {
		Itinerary itinerary = controler.getOrCreateItinerary(itineraryCode);

		Video video = videoRepository.findById(videoId).get();
		if (video == null)
			throw new Exception();

		Rating rate = new Rating(ratingDTO, video);
		ratingRepository.save(rate);
	}

	public VideoDTO createVideo(String itineraryCode, VideoDTO videoDTO) throws Exception {
		Itinerary itinerary = controler.getOrCreateItinerary(itineraryCode);
		Video video = new Video(videoDTO, itinerary);
		videoRepository.save(video);
		return new VideoDTO(video);
	}

	public List<RatingDTO> getAllVideosRating(String itineraryCode, int videoId) throws Exception {
		Itinerary itinerary = controler.getOrCreateItinerary(itineraryCode);

		Video video = videoRepository.findById(videoId).get();

		List<Rating> allRatings = ratingRepository.findByVideo(video);

		List<RatingDTO> rating = new ArrayList<>();

		for (Rating rate : allRatings) {
			rating.add(new RatingDTO(rate));
		}
		return rating;
	}

}
