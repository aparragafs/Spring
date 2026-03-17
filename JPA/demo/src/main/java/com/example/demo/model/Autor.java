package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Representa un autor en la biblioteca.
 * Cada autor puede estar asociado a múltiples {@link Libro}.
 * Incluye validaciones para el nombre, apellidos y fecha de nacimiento.
 * 
 * 
 */
@Entity
public class Autor {

    /**
     * Identificador único del autor.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del autor.
     * Obligatorio, con longitud entre 2 y 20 caracteres.
     */
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    /**
     * Apellidos del autor.
     * Obligatorio, con longitud entre 2 y 40 caracteres.
     */
    @NotNull(message = "Los apellidos no pueden ser nulos")
    @Size(min = 2, max = 40, message = "Los apellidos deben tener entre 2 y 100 caracteres")
    private String apellidos;

    /**
     * Fecha de nacimiento del autor.
     * Obligatoria.
     */
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    /**
     * Lista de libros escritos por el autor.
     * Relación 1 Autor - muchos Libros.
     */
    @OneToMany(mappedBy = "autor")
    @JsonIgnore 
    private List<Libro> libros;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Autor() {}

    /**
     * Constructor con campos principales del autor.
     *
     * @param nombre Nombre del autor.
     * @param apellidos Apellidos del autor.
     * @param fechaNacimiento Fecha de nacimiento del autor.
     */
    public Autor(String nombre, String apellidos, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    // -------------------- Getters y Setters --------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }
    
}
