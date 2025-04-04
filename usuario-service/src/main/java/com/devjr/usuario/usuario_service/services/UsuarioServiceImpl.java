package com.devjr.usuario.usuario_service.services;

import com.devjr.usuario.usuario_service.exceptions.ResourceNotFoundException;
import com.devjr.usuario.usuario_service.external.services.CalificacionService;
import com.devjr.usuario.usuario_service.external.services.HotelService;
import com.devjr.usuario.usuario_service.model.Calificacion;
import com.devjr.usuario.usuario_service.model.Hotel;
import com.devjr.usuario.usuario_service.model.Usuario;
import com.devjr.usuario.usuario_service.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    @Autowired
    HotelService hotelService;

    @Autowired
    CalificacionService calificacionService;

    UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        usuario.setUsuarioId(UUID.randomUUID().toString());
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getById(String usuarioId) {

        Usuario usuario= usuarioRepository.findById(usuarioId)
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));

        List<Calificacion> calificaciones = calificacionService.getCalificaciones(usuarioId);

        List<Calificacion> list = calificaciones.stream()
                .peek(calificacion -> {
                    Hotel hotel = hotelService.getHotel(calificacion.getHotelId());
                    log.info(String.valueOf("El valor es: "+calificacion.getHotelId()));
                    calificacion.setHotel(hotel);
                }).toList();
        log.info(String.valueOf(calificaciones));

        usuario.setCalificaciones(calificaciones);

        return usuario;
    }
}
