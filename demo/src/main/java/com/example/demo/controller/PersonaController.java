package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.model.Personas;

@RestController //Esta clase maneja peticiones REST.
public class PersonaController {

    private Persona personaGuardada;// Variable global para guardar la última persona enviada

    @GetMapping("/persona")// Endpoint GET /persona devuelve información de una persona
    public Persona obtenerPersona(){

        Persona p = new Persona(
                "Juan",
                "Perez",
                "Lopez",
                "1990-01-01",
                "Hombre"
        );

        return p;// Spring lo convierte a JSON y lo devuelve al navegador o Postman
    }

    @PostMapping("/envioFormulario") // Endpoint POST /envioFormulario recibe datos enviados por el usuario
    public String recibirDatos(
            @RequestParam String nombre,
            @RequestParam String apellido1,
            @RequestParam String apellido2,
            @RequestParam String fechaNacimiento,
            @RequestParam String sexo
    ){

        // Guardamos los datos recibidos en la variable global
        personaGuardada = new Persona(nombre, apellido1, apellido2, fechaNacimiento, sexo);

        System.out.println("Datos recibidos:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido1: " + apellido1);
        System.out.println("Apellido2: " + apellido2);
        System.out.println("Fecha nacimiento: " + fechaNacimiento);
        System.out.println("Sexo: " + sexo);

        return "Datos recibidos correctamente";// Mensaje que verá el usuario en Postman o navegador
    }


    private Personas personas = new Personas(); // inicializamos con 10 personas

    // GET devuelve la persona por DNI
    @GetMapping("/persona/{dni}")
    public Persona obtenerPersona(@PathVariable String dni) {
        for (Persona p : personas.getListaPersonas()) {
            if (p.getDni().equals(dni)) {
                return p;
        }
    }
        return null;
    }

    // PUT actualiza la persona por DNI usando @RequestBody
    @PutMapping("/persona/{dni}")
    public String actualizarPersona(@PathVariable String dni, @RequestBody Persona pActualizada) {
        for (int i = 0; i < personas.getListaPersonas().size(); i++) {
            Persona p = personas.getListaPersonas().get(i);
            if (p.getDni().equals(dni)) {
                // reemplazamos los datos
                p.setNombre(pActualizada.getNombre());
                p.setApellido1(pActualizada.getApellido1());
                p.setApellido2(pActualizada.getApellido2());
                p.setFechaNacimiento(pActualizada.getFechaNacimiento());
                p.setSexo(pActualizada.getSexo());
                return "Persona actualizada correctamente";
            }
        }
        return "Persona no encontrada";
    }
}
