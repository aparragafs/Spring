package com.example.demo.exception;

import java.time.LocalDateTime;

/**
 * Clase que representa la estructura del mensaje de error que se devuelve
 * al cliente cuando ocurre una excepción en la aplicación.
 * Contiene código de error, mensaje descriptivo y timestamp.
 */
public class ErrorMessage {

    /** Código de error HTTP */
    private int codigo;

    /** Mensaje descriptivo del error */
    private String mensaje;

    /** Marca de tiempo en que ocurrió el error */
    private LocalDateTime timestamp;

    /**
     * Constructor de la clase ErrorMessage.
     * 
     * @param codigo código de error HTTP
     * @param mensaje mensaje descriptivo del error
     * @param timestamp fecha y hora en que ocurrió el error
     */
    public ErrorMessage(int codigo, String mensaje, LocalDateTime timestamp) {
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    /**
     * Devuelve el código de error HTTP.
     * 
     * @return código de error
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el mensaje descriptivo del error.
     * 
     * @return mensaje de error
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Devuelve la marca de tiempo del error.
     * 
     * @return fecha y hora en que ocurrió el error
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}


