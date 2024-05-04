package com.example.integrador_3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Estudiante {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dni;
    @Column
    private Long libretaUniversitaria;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String genero;
    @Column int edad;
    @Column
    private String ciudad;
    @OneToMany(mappedBy = "estudiante")
    private List<Carrera_Estudiante> carreras;

}
