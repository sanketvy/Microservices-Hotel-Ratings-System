package com.learning.hotel.service.impl;

import com.learning.hotel.entity.Hotel;
import com.learning.hotel.repositories.HotelRepository;
import com.learning.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    HotelRepository hotelRepository;

    @Autowired
    HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).get();
    }

    @Override
    public Hotel deleteHotel(String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);

        if(hotel.isPresent()){
            hotelRepository.deleteById(id);
            return hotel.get();
        } else {
            throw new RuntimeException("Hotel not found with id - " + id);
        }
    }
}