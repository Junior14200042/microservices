package com.devjr.calificacion.calificacion_service.controller;

import com.devjr.calificacion.calificacion_service.model.Calificacion;
import com.devjr.calificacion.calificacion_service.service.ICalificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/calificaciones")
public class CalificacionController {

    private final ICalificacionService calificacionService;

    public CalificacionController(ICalificacionService calificacionService){
        this.calificacionService=calificacionService;
    }

    @GetMapping
    public ResponseEntity<List<Calificacion>> getAllCalificacion(){
        return new ResponseEntity<>(calificacionService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Calificacion> saveCalificacion(@RequestBody Calificacion calificacion){
        return new ResponseEntity<>(calificacionService.save(calificacion), HttpStatus.CREATED);
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionPorUsuario(@PathVariable String usuarioId){
        return new ResponseEntity<>(calificacionService.getCalificacionByUsuarioId(usuarioId),HttpStatus.OK);
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calificacion>> listarCalificacionPorHotel(@PathVariable String hotelId){
        return new ResponseEntity<>(calificacionService.getCalificacionByHotel(hotelId),HttpStatus.OK);
    }
}
