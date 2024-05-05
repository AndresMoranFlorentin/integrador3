package com.example.integrador_3.views;

import com.example.integrador_3.models.Carrera_Estudiante;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CarreraDto {
    private Long id_carrera;
    private String nombre;
    private int duracion;

    private Long cant_inscriptos;
    private List<Carrera_Estudiante> estudiantes;

    public CarreraDto(Long id_carrera, String nombre, int duracion) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = new ArrayList<>();
        this.cant_inscriptos = 0L;
    }

    public CarreraDto(Long id_carrera, String nombre, int duracion, Long cant_inscriptos) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.cant_inscriptos = cant_inscriptos;
    }
}
