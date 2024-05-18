package com.example.integrador_3.repositories;

import com.example.integrador_3.models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("CarreraRepo")
public interface CarreraRepo extends JpaRepository<Carrera, Long> {
    @Query("SELECT c.id_carrera, c.nombre, c.duracion, COUNT(ce.id.idCarrera) AS cant_inscriptos FROM Carrera c JOIN Carrera_Estudiante  ce ON (ce.id.idCarrera = c.id_carrera) GROUP BY c.id_carrera, c.nombre, c.duracion ORDER BY cant_inscriptos DESC ")
    List<Object[]> getCarrerasConInscriptos();
@Query(nativeQuery = true,value = "SELECT c.nombre, ce.fecha_inscripcion AS anio, COUNT(ce.fecha_inscripcion) AS inscriptos, 0 AS graduados " +
        "FROM Carrera c " +
        "INNER JOIN Carrera_Estudiante ce ON c.id_carrera = ce.id_carrera " +
        "GROUP BY c.nombre, ce.fecha_inscripcion " +
        "HAVING inscriptos != 0 " +
        "UNION " +
        "SELECT c1.nombre, ce.fecha_graduacion, 0 AS inscriptos, COUNT(ce.fecha_graduacion) AS graduados " +
        "FROM Carrera c1 " +
        "INNER JOIN Carrera_Estudiante ce ON c1.id_carrera = ce.id_carrera " +
        "GROUP BY c1.nombre, ce.fecha_graduacion " +
        "HAVING graduados != 0 " +
        "ORDER BY nombre, anio ASC")
    List<Object[]> getReporteCarreras();
}
