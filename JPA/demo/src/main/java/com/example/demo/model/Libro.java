package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * Representa un libro en la biblioteca.
 * Cada libro está asociado a un {@link Autor}, una {@link Editorial} y una {@link Tematica}.
 * Incluye validaciones para los campos ISBN, título, año y relaciones con otras entidades.
 * 
 * 
 */
@Entity
public class Libro {

    /**
     * Identificador único del libro.
     * Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código ISBN del libro.
     * Obligatorio, con longitud entre 10 y 13 caracteres.
     */
    @NotNull(message = "El ISBN es obligatorio")
    @Size(min = 10, max = 13, message = "El ISBN debe tener entre 10 y 13 caracteres")
    private String isbn;

    /**
     * Título del libro.
     * Obligatorio, con longitud entre 2 y 100 caracteres.
     */
    @NotNull(message = "El título es obligatorio")
    @Size(min = 2, max = 100)
    private String titulo;

    /**
     * Año de publicación del libro.
     * Debe ser un valor mayor o igual a 1500.
     */
    @Min(value = 1500, message = "El año debe ser válido")
    private int anioPublicacion;

    /**
     * Autor del libro.
     * Obligatorio y relacionado con {@link Autor}.
     */
    @NotNull(message = "El autor es obligatorio")
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    /**
     * Editorial del libro.
     * Obligatorio y relacionado con {@link Editorial}.
     */
    @NotNull(message = "La editorial es obligatoria")
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    /**
     * Temática del libro.
     * Obligatoria y relacionada con {@link Tematica}.
     */
    @NotNull(message = "La temática es obligatoria")
    @ManyToOne
    @JoinColumn(name = "tematica_id")
    private Tematica tematica;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Libro() {}

    /**
     * Constructor con todos los campos de la entidad Libro.
     *
     * @param isbn Código ISBN del libro.
     * @param titulo Título del libro.
     * @param anioPublicacion Año de publicación.
     * @param autor Autor del libro.
     * @param editorial Editorial del libro.
     * @param tematica Temática del libro.
     */
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor, Editorial editorial, Tematica tematica) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.editorial = editorial;
        this.tematica = tematica;
    }

    // -------------------- Getters y Setters --------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public Editorial getEditorial() { return editorial; }
    public void setEditorial(Editorial editorial) { this.editorial = editorial; }

    public Tematica getTematica() { return tematica; }
    public void setTematica(Tematica tematica) { this.tematica = tematica; }
}