package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Libro;

/**
 * Repositorio para la entidad {@link Libro}.
 * Extiende {@link JpaRepository} para proporcionar operaciones CRUD básicas
 * y define consultas personalizadas para filtrar libros por año, ISBN y editorial.
 * 
 * <p>Este repositorio se inyecta en {@link com.example.demo.service.LibroService}
 * para acceder a los datos de los libros en la base de datos.</p>
 * 
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    /**
     * Obtiene los libros publicados después de un año específico (JPQL).
     *
     * @param anio Año de referencia.
     * @return Lista de libros posteriores al año dado.
     */
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion > :anio")
    List<Libro> findLibrosPosterioresA(@Param("anio") int anio);

    /**
     * Obtiene los libros publicados después de un año específico (query method).
     *
     * @param anio Año de referencia.
     * @return Lista de libros posteriores al año dado.
     */
    List<Libro> findByAnioPublicacionGreaterThan(int anio);

    /**
     * Obtiene los libros publicados en un año específico (JPQL).
     *
     * @param anio Año de publicación.
     * @return Lista de libros publicados en el año dado.
     */
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion = :anio")
    List<Libro> findLibrosPorAnio(@Param("anio") int anio);

    /**
     * Obtiene los libros publicados en un año específico (query method).
     *
     * @param anio Año de publicación.
     * @return Lista de libros publicados en el año dado.
     */
    List<Libro> findByAnioPublicacion(int anio);

    /**
     * Obtiene un libro por su ISBN (JPQL).
     *
     * @param isbn ISBN del libro.
     * @return Libro con el ISBN dado, o null si no existe.
     */
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    Libro findLibroPorIsbn(@Param("isbn") String isbn);

    /**
     * Obtiene un libro por su ISBN (query method).
     *
     * @param isbn ISBN del libro.
     * @return Libro con el ISBN dado, o null si no existe.
     */
    Libro findByIsbn(String isbn);

    /**
     * Obtiene todos los libros de una editorial específica (JPQL).
     *
     * @param nombreEditorial Nombre de la editorial.
     * @return Lista de libros publicados por la editorial.
     */
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombreEditorial")
    List<Libro> findLibrosPorEditorial(@Param("nombreEditorial") String nombreEditorial);

    /**
     * Obtiene todos los libros de una editorial específica (query method).
     *
     * @param nombreEditorial Nombre de la editorial.
     * @return Lista de libros publicados por la editorial.
     */
    List<Libro> findByEditorialNombre(String nombreEditorial);

    /**
     * Obtiene los libros de una editorial específica publicados en un año determinado (JPQL).
     *
     * @param nombreEditorial Nombre de la editorial.
     * @param anio Año de publicación.
     * @return Lista de libros que cumplen los criterios.
     */
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombreEditorial AND l.anioPublicacion = :anio")
    List<Libro> findLibrosPorEditorialYAnio(@Param("nombreEditorial") String nombreEditorial,
                                            @Param("anio") int anio);

    /**
     * Obtiene los libros de una editorial específica publicados en un año determinado (query method).
     *
     * @param nombreEditorial Nombre de la editorial.
     * @param anio Año de publicación.
     * @return Lista de libros que cumplen los criterios.
     */
    List<Libro> findByEditorialNombreAndAnioPublicacion(String nombreEditorial, int anio);
}