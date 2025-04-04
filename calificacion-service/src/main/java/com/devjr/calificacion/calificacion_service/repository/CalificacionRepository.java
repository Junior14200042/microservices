package com.devjr.calificacion.calificacion_service.repository;

import com.devjr.calificacion.calificacion_service.model.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends MongoRepository<Calificacion, Long> {

    List<Calificacion> findByUsuarioId(String usuarioId);

    List<Calificacion> findByHotelId(String hotelId);
}
