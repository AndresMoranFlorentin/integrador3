package com.example.integrador_3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraEstudiantePorDni implements Serializable {
    @Column(name = "id_carrera")
    private Long idCarrera;

    @Column(name = "dni")
    private Long dni;
}