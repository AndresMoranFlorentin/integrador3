package com.example.integrador_3.views;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CarreraDto implements Serializable {
    private Long id_carrera;
    private String nombre;
    private int duracion;

    public CarreraDto(Long id_carrera, String nombre, int duracion) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
    }
}
