package com.devjr.usuario.usuario_service.services;

import com.devjr.usuario.usuario_service.exceptions.ResourceNotFoundException;
import com.devjr.usuario.usuario_service.model.Usuario;
import com.devjr.usuario.usuario_service.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

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
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
    }
}
