package com.learning.ratings.service.impl;

import com.learning.ratings.entity.Rating;
import com.learning.ratings.repositories.RatingRepository;
import com.learning.ratings.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;

    RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(String id) {
        return ratingRepository.findByRatingId(id);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUser(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getAllRatingByHotel(String id) {
        return ratingRepository.findByHotelId(id);
    }
}
