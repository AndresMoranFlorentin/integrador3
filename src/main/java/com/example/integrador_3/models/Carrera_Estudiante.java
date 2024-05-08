package com.example.integrador_3.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "carrera_estudiante")
@Data
@EqualsAndHashCode
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
   public Carrera_Estudiante(Long id_registro,Long dni,Long id_carrera,Integer fecha_inscripcion,Integer fecha_graduacion,Integer antiguedad){
       CarreraEstudiantePorDni nuevo= new CarreraEstudiantePorDni(dni,id_carrera);
       this.id=nuevo;
       this.id_registro=id_registro;
       this.fecha_inscripcion=fecha_inscripcion;
       this.fecha_graduacion=fecha_graduacion;
       this.antiguedad=antiguedad;
   }
}
