package com.itacademy.rating;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itacademy.rating.application.VideoController;
import com.itacademy.rating.application.dto.RatingDTO;
import com.itacademy.rating.application.dto.VideoDTO;

@CrossOrigin
@RestController
@RequestMapping(value = "/{itineraryCode}/videos")
public class VideoRestController {

	@Autowired
	private VideoController controller;

	@GetMapping()
	public String getVideos(@PathVariable String itineraryCode) throws Exception {
		return toJson(controller.getVideos(itineraryCode));
	}

	@PostMapping()
	public String createVideos(@PathVariable String itineraryCode, @RequestBody String jVideo) throws Exception {
		VideoDTO video = new Gson().fromJson(jVideo, VideoDTO.class);

		video = controller.createVideo(itineraryCode, video);
		return toJson(video);
	}

	private String toJson(Object obj) {
		return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(obj);
	}

	@PostMapping(value = "/{videoId}")
	public void rateVideos(@PathVariable String itineraryCode, @PathVariable int videoId,
			@Valid @RequestBody String rating) throws Exception {

		RatingDTO rate = new Gson().fromJson(rating, RatingDTO.class);
		controller.rateVideo(rate, itineraryCode, videoId);
	}

	@GetMapping(value = "/{videoId}")
	public String getAllVideosRating(@PathVariable String itineraryCode, @PathVariable int videoId) throws Exception {

		List<RatingDTO> ratingList = controller.getAllVideosRating(itineraryCode, videoId);

		String jRating = toJson(ratingList);

		JSONObject json = new JSONObject();
		json.put("average_rate", calculateAverageRate(ratingList));
		json.put("ratings", jRating);

		return json.toString();
	}

	private double calculateAverageRate(List<RatingDTO> ratingList) {
		int valorations = 0;
		for (RatingDTO rate : ratingList) {
			valorations += rate.getRating();
		}
		return valorations / ratingList.size() * 1.0;
	}
}