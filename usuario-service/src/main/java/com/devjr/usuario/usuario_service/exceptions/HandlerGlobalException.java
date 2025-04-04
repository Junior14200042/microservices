package com.devjr.usuario.usuario_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerGlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse error= new ApiResponse(HttpStatus.NOT_FOUND,ex.getMessage());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
