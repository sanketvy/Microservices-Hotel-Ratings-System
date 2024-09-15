package com.learning.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Hotel {

    @Id
    private String id;

    private String name;

    private String location;

    private String city;

    private String info;
}
