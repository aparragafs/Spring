package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Personas {

    private List<Persona> listaPersonas;

    public Personas() {
        listaPersonas = new ArrayList<>();
        // Inicializamos 10 personas ficticias
        listaPersonas.add(new Persona("11111111A", "Juan", "Perez", "Lopez", "1990-01-01", "Hombre"));
        listaPersonas.add(new Persona("22222222B", "Ana", "Gomez", "Diaz", "1992-03-12", "Mujer"));
        listaPersonas.add(new Persona("33333333C", "Luis", "Martinez", "Santos", "1988-07-23", "Hombre"));
        listaPersonas.add(new Persona("44444444D", "Maria", "Lopez", "Garcia", "1995-11-05", "Mujer"));
        listaPersonas.add(new Persona("55555555E", "Pedro", "Fernandez", "Ruiz", "1991-02-15", "Hombre"));
        listaPersonas.add(new Persona("66666666F", "Lucia", "Diaz", "Moreno", "1989-08-19", "Mujer"));
        listaPersonas.add(new Persona("77777777G", "Carlos", "Sanchez", "Torres", "1993-04-30", "Hombre"));
        listaPersonas.add(new Persona("88888888H", "Elena", "Vega", "Lopez", "1994-09-12", "Mujer"));
        listaPersonas.add(new Persona("99999999I", "Miguel", "Gonzalez", "Diaz", "1990-12-01", "Hombre"));
        listaPersonas.add(new Persona("10101010J", "Laura", "Ramirez", "Santos", "1996-06-20", "Mujer"));
    }

    public List<Persona> getListaPersonas() { return listaPersonas; }

    public void setListaPersonas(List<Persona> listaPersonas) { this.listaPersonas = listaPersonas; }

    
}
