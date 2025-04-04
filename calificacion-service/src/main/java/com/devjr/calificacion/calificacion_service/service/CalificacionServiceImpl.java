package com.devjr.calificacion.calificacion_service.service;

import com.devjr.calificacion.calificacion_service.model.Calificacion;
import com.devjr.calificacion.calificacion_service.repository.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements ICalificacionService{

    private final CalificacionRepository calificacionRepository;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository){
        this.calificacionRepository= calificacionRepository;
    }

    @Override
    public List<Calificacion> getAll() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> getCalificacionByUsuarioId(String usuarioId) {
        return calificacionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Calificacion> getCalificacionByHotel(String hotelId) {
        return calificacionRepository.findByHotelId(hotelId);
    }
}
