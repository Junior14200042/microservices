package com.devjr.calificacion.calificacion_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("calificaciones")
public class Calificacion {

    @Id
    private String calificacionId;
    private String usuarioId;
    private String hotelId;
    private int calificacion;
    private String observaciones;
}
