package com.devjr.hotel.hotel_service.controller;

import com.devjr.hotel.hotel_service.model.Hotel;
import com.devjr.hotel.hotel_service.service.IHotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    private final IHotelService hotelService;

    public HotelController(IHotelService hotelService){
        this.hotelService=hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return  new ResponseEntity<>(hotelService.saveHotel(hotel),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id){
        return  new ResponseEntity<>(hotelService.getById(id),HttpStatus.OK);
    }
}
