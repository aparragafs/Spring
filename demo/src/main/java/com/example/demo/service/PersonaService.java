package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.model.Personas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servicio que maneja la lógica de negocio relacionada con personas.
 * Contiene operaciones de obtención, actualización y almacenamiento de personas en memoria.
 * 
 * Endpoints como GET, POST y PUT del controlador delegan la lógica aquí.
 */
@Service
public class PersonaService {

    private static final Logger logger = LoggerFactory.getLogger(PersonaService.class);

    /** Lista inicial de personas ficticias */
    private Personas personas = new Personas();

    /**
     * Obtiene una persona por su DNI.
     * 
     * @param dni DNI de la persona a buscar
     * @return objeto {@link Persona} si existe, o null si no se encuentra
     * @throws RuntimeException si la persona no existe
     */
    public Persona obtenerPersonaPorDni(String dni) {
        logger.info("Buscando persona con DNI [{}]", dni);
        for (Persona p : personas.getListaPersonas()) {
            if (p.getDni().equals(dni)) {
                
                logger.info("Persona encontrada: {}", p.getNombreCompleto());
                return p;
            }
        }

        logger.warn("No se encontró persona con DNI [{}]", dni);
        throw new RuntimeException("Persona no encontrada con DNI: " + dni);
    }

    /**
     * Actualiza los datos de una persona existente según el DNI.
     * 
     * @param dni DNI de la persona a actualizar
     * @param pActualizada objeto {@link Persona} con los nuevos datos
     * @return mensaje indicando si la actualización fue correcta o si no se encontró la persona
     * @throws RuntimeException si la persona no existe
     */
    public String actualizarPersona(String dni, Persona pActualizada) {
        logger.info("Actualizando persona con DNI [{}]", dni);
        List<Persona> lista = personas.getListaPersonas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDni().equals(dni)) {
                lista.set(i, pActualizada);
                logger.info("Persona con DNI [{}] actualizada correctamente", dni);
                return "Persona actualizada correctamente";
            }
        }
        logger.warn("No se encontró persona con DNI [{}] para actualizar", dni);
        throw new RuntimeException("Persona no encontrada con DNI: " + dni);
    }

    /**
     * Guarda una nueva persona en memoria.
     * 
     * @param p objeto {@link Persona} a almacenar
     */
    public void guardarPersona(Persona p) {
        logger.info("Guardando nueva persona con DNI [{}]", p.getDni());
        personas.getListaPersonas().add(p);
        logger.info("Persona con DNI [{}] guardada correctamente", p.getDni());
    }

    /**
     * Devuelve un ejemplo de persona.
     * 
     * @return objeto {@link Persona} de ejemplo
     */
    public Persona obtenerPersonaEjemplo() {
        logger.info("Devolviendo persona de ejemplo");
        return new Persona("11111111B","Juan", "Perez", "Lopez", "1990-01-01", "Hombre");
        
    }
}