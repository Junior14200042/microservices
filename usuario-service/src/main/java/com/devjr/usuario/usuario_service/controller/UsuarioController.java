package com.devjr.usuario.usuario_service.controller;

import com.devjr.usuario.usuario_service.model.Usuario;
import com.devjr.usuario.usuario_service.services.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    UsuarioController(IUsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return new ResponseEntity<>(usuarioService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return  new ResponseEntity<>(usuarioService.saveUsuario(usuario),HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getById(@PathVariable String usuarioId){
        return new ResponseEntity<>(usuarioService.getById(usuarioId),HttpStatus.OK);
    }
}
