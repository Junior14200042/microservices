package com.devjr.calificacion.calificacion_service.service;

import com.devjr.calificacion.calificacion_service.model.Calificacion;

import java.util.List;

public interface ICalificacionService {

    List<Calificacion> getAll();

    Calificacion save(Calificacion calificacion);

    List<Calificacion> getCalificacionByUsuarioId(String usuarioId);

    List<Calificacion> getCalificacionByHotel(String hotelId);
}
