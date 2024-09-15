package com.learning.ratings.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document("ratings")
public class Rating {

    @Id
    private String ratingId;

    private String userId;

    private String hotelId;

    private String rating;

    private String comment;

}
