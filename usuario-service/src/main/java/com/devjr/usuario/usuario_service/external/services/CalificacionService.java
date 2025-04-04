package com.devjr.usuario.usuario_service.external.services;

import com.devjr.usuario.usuario_service.model.Calificacion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "calificacion-service")
public interface CalificacionService {

    @GetMapping("/api/v1/calificaciones/usuarios/{usuarioId}")
    List<Calificacion> getCalificaciones(@PathVariable String usuarioId);

}
