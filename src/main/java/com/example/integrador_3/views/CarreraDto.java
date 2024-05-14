package com.example.integrador_3.views;

import com.example.integrador_3.models.Carrera_Estudiante;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
