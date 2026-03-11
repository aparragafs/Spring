package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Clase encargada de manejar todas las excepciones que ocurren en los controladores.
 * esta clase captura cualquier excepción lanzada
 * en la aplicación y devuelve un JSON con información del error.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Método que captura cualquier excepción de tipo {@link Exception} que ocurra
     * en los controladores y devuelve un objeto {@link ErrorMessage} con detalles
     * del error.
     * 
     * @param ex la excepción lanzada
     * @return {@link ResponseEntity} con el {@link ErrorMessage} y el código HTTP 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> manejarError(Exception ex){

        ErrorMessage error = new ErrorMessage(
                500,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}