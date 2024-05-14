package com.example.integrador_3.models;

import aj.org.objectweb.asm.commons.Remapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    private Long libreta_universitaria;
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
    @JsonIgnore // Evitar recursión infinita
    private List<Carrera_Estudiante> carreras;
    public Estudiante(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libreta_universitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
        this.carreras=new ArrayList<>();
    }
}
