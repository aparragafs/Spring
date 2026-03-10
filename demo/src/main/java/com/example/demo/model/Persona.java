package com.example.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


/**
 * Clase que representa a una persona con información básica.
 * Validaciones de los campos:
 * - dni: obligatorio, formato 8 números + letra
 * - nombre, apellido1: obligatorio
 * - fechaNacimiento: obligatorio, formato yyyy-MM-dd
 * - sexo: obligatorio
 */
public class Persona {

    /** Documento Nacional de Identidad de la persona */
    @NotBlank(message = "DNI es obligatorio")
    @Pattern(regexp = "\\d{8}[A-Za-z]", message = "DNI debe tener 8 números y una letra")
    private String dni;

    /** Nombre de la persona */
    @NotBlank(message = "DNI es obligatorio")
    private String nombre;

    /** Primer apellido de la persona */
    @NotBlank(message = "Primer apellido obligatorio")
    private String apellido1;

    /** Segundo apellido de la persona */
    private String apellido2;

    /** Nombre completo (Nombre + Apellido1 + Apellido2) */
    private String nombreCompleto;

    /** Fecha de nacimiento en formato YYYY-MM-DD */
    @NotBlank(message = "Fecha de nacimiento obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Formato fecha YYYY-MM-DD")
    private String fechaNacimiento;

    /** Sexo de la persona */
    @NotBlank(message = "Sexo obligatorio")
    private String sexo;

    /**
     * Constructor vacío.
     * 
     */
    public Persona() {}

    /**
     * Constructor con parámetros.
     * Inicializa todos los atributos de la persona y calcula el nombre completo.
     * 
     * @param dni Documento Nacional de Identidad
     * @param nombre Nombre de la persona
     * @param apellido1 Primer apellido
     * @param apellido2 Segundo apellido
     * @param fechaNacimiento Fecha de nacimiento en formato YYYY-MM-DD
     * @param sexo Sexo de la persona
     */
    public Persona(String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        actualizarNombreCompleto();
    }

    // ========================
    // Getters y Setters
    // ========================

    /**
     * Métodos para obtener y modificar los atributos de la persona.
     * Los setters de nombre y apellidos actualizan automáticamente {@code nombreCompleto}.
     */
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; actualizarNombreCompleto(); }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; actualizarNombreCompleto(); }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; actualizarNombreCompleto(); }

    public String getNombreCompleto() { return nombreCompleto; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    // ========================
    // Métodos privados
    // ========================

    /**
     * Actualiza {@code nombreCompleto} concatenando nombre, primer apellido y segundo apellido.
     */
    private void actualizarNombreCompleto() {
        this.nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
    }
}
