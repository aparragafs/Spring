package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Representa una temática o categoría de los libros en la biblioteca.
 * Cada temática puede estar asociada a múltiples {@link Libro}.
 * Incluye validaciones para la categoría.
 * 
 */
@Entity
public class Tematica {

    /**
     * Identificador único de la temática.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría de la temática.
     * Obligatorio, con longitud entre 3 y 50 caracteres.
     */
    @NotNull(message = "La categoría es obligatoria")
    @Size(min = 3, max = 50)
    private String categoria;

    /**
     * Lista de libros asociados a esta temática.
     * Relación 1 Temática - muchos Libros.
     */
    @OneToMany(mappedBy = "tematica")
    @JsonIgnore 
    private List<Libro> libros;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Tematica() {}

    /**
     * Constructor con el nombre de la categoría.
     *
     * @param categoria Nombre de la categoría de la temática.
     */
    public Tematica(String categoria) {
        this.categoria = categoria;
    }

    // -------------------- Getters y Setters --------------------
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
}
