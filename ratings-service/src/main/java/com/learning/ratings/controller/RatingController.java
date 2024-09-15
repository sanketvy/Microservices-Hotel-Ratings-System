package com.learning.ratings.controller;

import com.learning.ratings.entity.Rating;
import com.learning.ratings.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    RatingService ratingService;

    RatingController(RatingService ratingService){
        this.ratingService = ratingService;
    }

    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating newRating = ratingService.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRating);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByUser(id));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatingByHotel(id));
    }
}
