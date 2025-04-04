package com.devjr.hotel.hotel_service.service;

import com.devjr.hotel.hotel_service.Repository.HotelRepository;
import com.devjr.hotel.hotel_service.exceptions.ResourceNotFoundException;
import com.devjr.hotel.hotel_service.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements IHotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository){
        this.hotelRepository=hotelRepository;
    }


    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getById(String id) {

        return hotelRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("no encontrado"));
    }
}
