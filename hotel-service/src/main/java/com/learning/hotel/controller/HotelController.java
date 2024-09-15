package com.learning.hotel.controller;

import com.learning.hotel.entity.Hotel;
import com.learning.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    HotelService hotelService;

    @Autowired
    HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        hotel.setId(UUID.randomUUID().toString());
        Hotel newHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHotel);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
    }
}
