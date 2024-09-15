package com.learning.hotel.service;

import com.learning.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotel(String id);

    Hotel deleteHotel(String id);
}
