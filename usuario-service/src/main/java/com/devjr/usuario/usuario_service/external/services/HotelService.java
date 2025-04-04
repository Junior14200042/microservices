package com.devjr.usuario.usuario_service.external.services;

import com.devjr.usuario.usuario_service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("/api/v1/hotel/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
