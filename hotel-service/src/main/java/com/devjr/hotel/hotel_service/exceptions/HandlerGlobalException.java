package com.devjr.hotel.hotel_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerGlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ApiResponse apiResponse = new ApiResponse(HttpStatus.NOT_FOUND, ex.getMessage());

        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
