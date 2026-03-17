package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Libro;
import com.example.demo.service.LibroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controlador REST para la gestión de libros.
 * Proporciona endpoints para listar libros, filtrarlos por año, ISBN o editorial.
 *
 * <p>Utiliza {@link LibroService} para la lógica de negocio.</p>
 *
 */
@RestController
@RequestMapping("/libros")
public class LibroController {

    /**
     * Logger para imprimir mensajes informativos en la consola.
     */
    private static final Logger logger = LoggerFactory.getLogger(LibroController.class);

    /**
     * Servicio encargado de la lógica de libros.
     */
    @Autowired
    private LibroService libroService;

    /**
     * Endpoint para listar todos los libros.
     *
     * @return Lista de todos los libros en JSON.
     */
    @GetMapping("/todos")
    public List<Libro> listarTodos() {
        logger.info("El usuario ha solicitado listar todos los libros");
        return libroService.listarLibros();
    }

    /**
     * Endpoint para listar libros publicados después de un año específico.
     *
     * @param anio Año de referencia.
     * @return Lista de libros publicados después del año indicado.
     */
    @GetMapping("/posteriores/{anio}")
    public List<Libro> listarPosteriores(@PathVariable int anio) {
        logger.info("El usuario ha solicitado libros posteriores al año {}", anio);
        return libroService.listarLibrosPosteriores(anio);
    }

    /**
     * Endpoint para listar libros posteriores a un año usando query automática.
     *
     * @param anio Año de referencia.
     * @return Lista de libros publicados después del año indicado.
     */
    @GetMapping("/posterioresAuto/{anio}")
    public List<Libro> listarPosterioresAuto(@PathVariable int anio) {
        logger.info("El usuario ha solicitado libros posteriores (auto) al año {}", anio);
        return libroService.listarLibrosPosterioresAuto(anio);
    }

    /**
     * Endpoint para obtener libros de un año específico.
     *
     * @param anio Año de publicación.
     * @return Lista de libros publicados en el año indicado.
     */
    @GetMapping("/anio/{anio}")
    public List<Libro> getLibrosPorAnio(@PathVariable int anio) {
        logger.info("El usuario consulta libros del año {}", anio);
        return libroService.listarLibrosPorAnio(anio);
    }

    /**
     * Endpoint para obtener un libro por su ISBN.
     *
     * @param isbn ISBN del libro.
     * @return Libro encontrado o null si no existe.
     */
    @GetMapping("/isbn/{isbn}")
    public Libro getLibroPorIsbn(@PathVariable String isbn) {
        logger.info("El usuario consulta libro con ISBN {}", isbn);
        return libroService.listarLibroPorIsbn(isbn);
    }

    /**
     * Endpoint para obtener libros de una editorial específica.
     *
     * @param nombre Nombre de la editorial.
     * @return Lista de libros de la editorial indicada.
     */
    @GetMapping("/editorial/{nombre}")
    public List<Libro> getLibrosPorEditorial(@PathVariable String nombre) {
        logger.info("El usuario consulta libros de la editorial {}", nombre);
        return libroService.listarLibrosPorEditorial(nombre);
    }

    /**
     * Endpoint para obtener libros de una editorial y año específicos.
     *
     * @param nombre Nombre de la editorial.
     * @param anio Año de publicación.
     * @return Lista de libros de la editorial indicada y año especificado.
     */
    @GetMapping("/editorial/{nombre}/anio/{anio}")
    public List<Libro> getLibrosPorEditorialYAnio(@PathVariable String nombre, @PathVariable int anio) {
        logger.info("El usuario consulta libros de {} del año {}", nombre, anio);
        return libroService.listarLibrosPorEditorialYAnio(nombre, anio);
    }
}