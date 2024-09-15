package com.learning.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name = "USER_RATING")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ratingId;

    private String userId;

    private String hotelId;

    private String rating;

    private String comment;
}
