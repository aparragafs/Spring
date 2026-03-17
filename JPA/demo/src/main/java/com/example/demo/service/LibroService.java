package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servicio para la gestión de libros.
 * Contiene la lógica de negocio relacionada con la búsqueda y listado de libros.
 * Utiliza {@link LibroRepository} para acceder a la base de datos.
 * 
 * 
 */
@Service
public class LibroService {

    /**
     * Logger para mensajes informativos en la consola.
     */
    private static final Logger logger = LoggerFactory.getLogger(LibroService.class);

    /**
     * Repositorio para acceder a la base de datos de libros.
     */
    @Autowired
    private LibroRepository libroRepository;

    /**
     * Lista todos los libros existentes en la base de datos.
     *
     * @return Lista de todos los libros.
     */
    public List<Libro> listarLibros() {
        logger.info("Accediendo a la base de datos: listar todos los libros");
        return libroRepository.findAll();
    }

    /**
     * Lista los libros publicados después de un año específico.
     *
     * @param anio Año de referencia.
     * @return Lista de libros publicados después del año indicado.
     */
    public List<Libro> listarLibrosPosteriores(int anio) {
        logger.info("Buscando libros posteriores al año {}", anio);
        return libroRepository.findLibrosPosterioresA(anio);
    }

    /**
     * Lista libros posteriores a un año usando query automática.
     *
     * @param anio Año de referencia.
     * @return Lista de libros posteriores al año indicado.
     */
    public List<Libro> listarLibrosPosterioresAuto(int anio) {
        logger.info("Buscando libros (auto) posteriores al año {}", anio);
        return libroRepository.findByAnioPublicacionGreaterThan(anio);
    }

    /**
     * Lista libros de un año específico.
     *
     * @param anio Año de publicación.
     * @return Lista de libros publicados en el año indicado.
     */
    public List<Libro> listarLibrosPorAnio(int anio) {
        logger.info("Buscando libros del año {}", anio);
        return libroRepository.findByAnioPublicacion(anio);
    }

    /**
     * Busca un libro por su ISBN.
     *
     * @param isbn ISBN del libro.
     * @return Libro encontrado o null si no existe.
     */
    public Libro listarLibroPorIsbn(String isbn) {
        logger.info("Buscando libro con ISBN {}", isbn);

        Libro libro = libroRepository.findByIsbn(isbn);

        if (libro == null) {
            logger.warn("No se encontró libro con ISBN {}", isbn);
        }

        return libro;
    }

    /**
     * Lista libros de una editorial específica.
     *
     * @param nombreEditorial Nombre de la editorial.
     * @return Lista de libros de la editorial indicada.
     */
    public List<Libro> listarLibrosPorEditorial(String nombreEditorial) {
        logger.info("Buscando libros de la editorial {}", nombreEditorial);
        return libroRepository.findByEditorialNombre(nombreEditorial);
    }

    /**
     * Lista libros de una editorial y año específicos.
     *
     * @param nombreEditorial Nombre de la editorial.
     * @param anio Año de publicación.
     * @return Lista de libros que coinciden con la editorial y año indicados.
     */
    public List<Libro> listarLibrosPorEditorialYAnio(String nombreEditorial, int anio) {
        logger.info("Buscando libros de {} del año {}", nombreEditorial, anio);
        return libroRepository.findByEditorialNombreAndAnioPublicacion(nombreEditorial, anio);
    }
}