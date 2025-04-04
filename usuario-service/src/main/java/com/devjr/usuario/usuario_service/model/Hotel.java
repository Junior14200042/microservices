package com.devjr.usuario.usuario_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private String id;
    private String nombre;
    private String ubicacion;
    private String informacion;
}
