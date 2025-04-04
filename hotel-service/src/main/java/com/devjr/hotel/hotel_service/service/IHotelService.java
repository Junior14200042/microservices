package com.devjr.hotel.hotel_service.service;

import com.devjr.hotel.hotel_service.model.Hotel;

import java.util.List;

public interface IHotelService {

    List<Hotel> getAll();

    Hotel saveHotel(Hotel hotel);

    Hotel getById(String id);
}
