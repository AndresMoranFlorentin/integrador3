package com.example.integrador_3.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarreraDtoInscripto {
    private Long id_carrera;
    private String nombre;
    private int duracion;
    private Long cant_inscriptos;
    public CarreraDtoInscripto(Long id_carrera, String nombre, int duracion, Long cant_inscriptos) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cant_inscriptos = cant_inscriptos;
    }


}
