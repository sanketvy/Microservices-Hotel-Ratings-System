package com.learning.ratings.repositories;

import com.learning.ratings.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {

    Rating findByRatingId(String id);

    List<Rating> findByUserId(String id);

    List<Rating> findByHotelId(String id);
}
