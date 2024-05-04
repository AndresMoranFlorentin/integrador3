package com.example.integrador_3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
public class Carrera {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrera;
    @Column
    private String nombre;
    @Column
    private int duracion;
    @OneToMany(mappedBy = "carrera")
    private List<Carrera_Estudiante> estudiantes;

}
