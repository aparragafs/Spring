package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador REST que expone los endpoints para trabajar con personas.
 * Delegamos la lógica a {@link PersonaService} para mantener MVC.
 * Permite operaciones GET, POST y PUT.
 * 
 * Endpoints:
 * - GET /persona : devuelve una persona de ejemplo
 * - POST /envioFormulario : recibe y guarda una persona enviada por parámetros
 * - GET /persona/{dni} : devuelve una persona por su DNI
 * - PUT /persona/{dni} : actualiza los datos de una persona existente
 */
@RestController
public class PersonaController {

    private static final Logger logger = LoggerFactory.getLogger(PersonaController.class);

    /** Servicio que maneja la lógica de negocio de las personas */
    private final PersonaService personaService;

    /**
     * Constructor que inyecta {@link PersonaService}.
     * 
     * @param personaService servicio de personas
     */
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    /**
     * Devuelve una persona de ejemplo.
     * 
     * @return objeto {@link Persona} en JSON
     */
    @GetMapping("/persona")
    public Persona obtenerPersona() {
        logger.info("Se solicitó la persona de ejemplo");
        return personaService.obtenerPersonaEjemplo();
    }

    /**
     * Recibe datos de una persona por parámetros y la guarda en memoria.
     * 
     * @param dni DNI de la persona
     * @param nombre Nombre de la persona
     * @param apellido1 Primer apellido
     * @param apellido2 Segundo apellido
     * @param fechaNacimiento Fecha de nacimiento (YYYY-MM-DD)
     * @param sexo Sexo de la persona
     * @return mensaje confirmando la recepción de datos
     */
    @PostMapping("/envioFormulario")
    public String recibirDatos(@RequestParam String dni, @RequestParam String nombre,
                            @RequestParam String apellido1, @RequestParam String apellido2,
                            @RequestParam String fechaNacimiento, @RequestParam String sexo) {
        logger.info("El usuario con DNI [{}] ha enviado datos para crear una persona", dni);
        Persona p = new Persona(dni, nombre, apellido1, apellido2, fechaNacimiento, sexo);
        personaService.guardarPersona(p);

        logger.info("Persona con DNI [{}] guardada correctamente", dni);
        return "Datos recibidos correctamente";
    }

    /**
     * Devuelve los datos de una persona según su DNI.
     * 
     * @param dni DNI de la persona a buscar
     * @return objeto {@link Persona} correspondiente o null si no existe
     */
    @GetMapping("/persona/{dni}")
    public Persona obtenerPersona(@PathVariable String dni) {
        logger.info("Se solicitó la persona con DNI [{}]", dni);
        return personaService.obtenerPersonaPorDni(dni);
    }

    /**
     * Actualiza los datos de una persona existente usando {@link Persona} en el body.
     * 
     * @param dni DNI de la persona a actualizar
     * @param pActualizada objeto {@link Persona} con los nuevos datos
     * @return mensaje confirmando la actualización o indicando que no se encontró la persona
     */
    @PutMapping("/persona/{dni}")
    public String actualizarPersona(@PathVariable String dni, @Valid @RequestBody Persona pActualizada) {
        logger.info("Solicitud de actualización para persona con DNI [{}]", dni);
        return personaService.actualizarPersona(dni, pActualizada);
    }
}