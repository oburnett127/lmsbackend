package com.oburnett127.lms.services;

import com.oburnett127.lms.model.Rating;

import java.util.List;

public interface RatingOperations {

	Rating createRating(Rating Rating);

	List<Rating> getRatings();

	Rating getRating(Integer id);

	Rating updateRating(Rating Rating);

	void deleteRating(Integer id);

}