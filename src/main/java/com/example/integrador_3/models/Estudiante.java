package com.example.integrador_3.models;

import aj.org.objectweb.asm.commons.Remapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "estudiante")
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
    @Column
    int edad;
    @Column
    private String ciudad;
    @OneToMany(mappedBy = "estudiante")
    private List<Carrera_Estudiante> carreras;

    public Estudiante(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
