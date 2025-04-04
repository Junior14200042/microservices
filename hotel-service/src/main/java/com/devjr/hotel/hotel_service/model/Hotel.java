package com.devjr.hotel.hotel_service.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    private String id;
    private String nombre;
    private String ubicacion;
    private String informacion;

}
