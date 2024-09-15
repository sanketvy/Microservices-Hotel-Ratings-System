package com.learning.ratings.service;


import com.learning.ratings.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating getRating(String id);

    List<Rating> getAllRatings();

    List<Rating> getAllRatingByUser(String id);

    List<Rating> getAllRatingByHotel(String id);

}
