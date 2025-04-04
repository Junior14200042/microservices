package com.devjr.usuario.usuario_service.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse {

    private HttpStatus httpStatus;
    private String message;
    private LocalDateTime localDateTime;

    ApiResponse(HttpStatus httpStatus, String message){
        this.httpStatus=httpStatus;
        this.message=message;
        this.localDateTime=LocalDateTime.now();
    }

}
