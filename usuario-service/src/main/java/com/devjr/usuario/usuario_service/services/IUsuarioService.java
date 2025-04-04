package com.devjr.usuario.usuario_service.services;

import com.devjr.usuario.usuario_service.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> getAll();

    Usuario saveUsuario(Usuario usuario);

    Usuario getById(String usuarioId);
}
