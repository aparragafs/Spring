package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Representa una editorial en la biblioteca.
 * Cada editorial puede estar asociada a múltiples {@link Libro}.
 * Incluye validaciones para nombre y razón social.
 * 
 */
@Entity
public class Editorial {

    /**
     * Identificador único de la editorial.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la editorial.
     * Obligatorio, con longitud entre 2 y 100 caracteres.
     */
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100)
    private String nombre;

    /**
     * Razón social de la editorial.
     * Obligatoria, con longitud entre 2 y 150 caracteres.
     */
    @NotNull(message = "La razón social es obligatoria")
    @Size(min = 2, max = 150)
    private String razonSocial;

    /**
     * Lista de libros publicados por la editorial.
     * Relación 1 Editorial - muchos Libros.
     */
    @OneToMany(mappedBy = "editorial")
    @JsonIgnore 
    private List<Libro> libros;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Editorial() {}

    /**
     * Constructor con campos principales de la editorial.
     *
     * @param nombre Nombre de la editorial.
     * @param razonSocial Razón social de la editorial.
     */
    public Editorial(String nombre, String razonSocial) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
    }

    // -------------------- Getters y Setters --------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
}