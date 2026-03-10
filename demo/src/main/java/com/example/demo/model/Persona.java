package com.example.demo.model;

public class Persona {

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nombreCompleto;
    private String fechaNacimiento;
    private String sexo;

    // Constructor vacío
    public Persona() {}

    // Constructor con parámetros
    public Persona(String nombre, String apellido1, String apellido2, String fechaNacimiento, String sexo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nombreCompleto = nombre + " " + apellido1 + " " + apellido2;
    }

    public Persona(String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    //Getters
    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido1() { return apellido1; }
    public String getApellido2() { return apellido2; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getSexo() { return sexo; }

    //Setters
    public void setDni(String dni) { this.dni = dni; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    
}
