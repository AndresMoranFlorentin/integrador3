package com.example.integrador_3.views;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Getter
public class EstudianteDto {
    private Long dni;
    private Long libretaUniversitaria;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String ciudad;

    public EstudianteDto(Long dni, Long libretaUniversitaria, String nombre, String apellido, String genero, int edad, String ciudad) {
        this.dni = dni;
        this.libretaUniversitaria = libretaUniversitaria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.ciudad = ciudad;
    }
}
