package com.example.integrador_3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrera_estudiante")
@Data
@NoArgsConstructor
public class Carrera_Estudiante {
    @EmbeddedId
    private CarreraEstudiantePorDni id;
    @Column
    Long id_registro;
    @Column
    private Integer fecha_inscripcion;
    @Column
    private Integer fecha_graduacion;
    @Column
    private int antiguedad;
    // Definir la relación con Carrera

    @ManyToOne
    @JoinColumn(name = "id_carrera", insertable = false, updatable = false)
    private Carrera carrera;

    // Definir la relación con Estudiante
    @ManyToOne
    @JoinColumn(name = "dni", insertable = false, updatable = false)
    private Estudiante estudiante;
   /* @ManyToOne
    @JoinColumn(name = "fk_carrera")
    private Carrera carrera;
    @ManyToOne
    @JoinColumn(name = "fk_estudiante")
    private Estudiante estudiante;*/

}
