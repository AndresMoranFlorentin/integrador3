package com.example.integrador_3.modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Carrera_Estudiante {
    @Id
    private Long id;
    @Id
    private Long dni;
    @Id
    private Long id_carrera;
    @Column
    private Integer fecha_inscripcion;
    @Column
    private Integer fecha_graduacion;
    @Column
    private int antiguedad;
    @ManyToOne
    @JoinColumn(name = "fk_carrera")
    private Carrera carrera;
    @ManyToOne
    @JoinColumn(name = "fk_estudiante")
    private Estudiante estudiante;

}
