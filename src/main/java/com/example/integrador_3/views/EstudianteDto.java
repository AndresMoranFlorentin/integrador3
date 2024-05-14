package com.example.integrador_3.views;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EstudianteDto implements Serializable {
    private Long dni;
    private Long libreta_universitaria;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String ciudad;

    public EstudianteDto(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libreta_universitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
