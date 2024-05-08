package com.example.integrador_3.repositories;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.views.CarreraDto;
import com.example.integrador_3.views.CarreraDtoInscripto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarreraRepo extends JpaRepository<Carrera, Long> {
    @Query("SELECT c FROM Carrera c WHERE c.id_carrera=:id_carrera")
    public Carrera getCarreraByID(Long id_carrera);

    @Query ("SELECT c.id_carrera,c.nombre,c.duracion, COUNT(c.duracion) AS cant_inscriptos" +
            " FROM Carrera AS c JOIN Carrera_Estudiante AS ce" +
            " WHERE (ce.carrera=c) " +
            " GROUP BY (c.id_carrera) " +
            " ORDER BY cant_inscriptos DESC")
    public List<CarreraDto> getCarrerasConInscriptos();

}
