package com.example.integrador_3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
public class Carrera {
    @Id
    private Long id_carrera;
    @Column
    private String nombre;
    @Column
    private int duracion;
    @OneToMany(mappedBy = "carrera")
    private List<Carrera_Estudiante> estudiantes;

    public Carrera(Long id_carrera, String nombre, int duracion ) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = new ArrayList<>();
    }
}
