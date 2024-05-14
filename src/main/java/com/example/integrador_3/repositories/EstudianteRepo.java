package com.example.integrador_3.repositories;

import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.views.EstudianteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EstudianteRepo")
public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.genero=:genero ")
    public List<Estudiante> findByGenero(@Param("genero") String genero);

    @Query("SELECT new Estudiante(e.dni,e.libreta_universitaria,e.nombre,e.apellido,e.genero,e.edad,e.ciudad) FROM Estudiante e WHERE e.libreta_universitaria=:lib ")
    public Estudiante getEstudiantePorNumLibreta(@Param("lib")Long lib);

    @Query("SELECT new Estudiante (e.dni,e.libreta_universitaria,e.nombre,e.apellido,e.genero,e.edad,e.ciudad) FROM Estudiante e ORDER BY e.apellido DESC")
    public List<Estudiante> getEstudiantesPorOrdenDelApellido();

    @Query(nativeQuery = true, value = "SELECT DISTINCT e.dni, e.libreta_universitaria, e.nombre, e.apellido, e.genero, e.edad, e.ciudad " +
            "FROM Estudiante e " +
            "JOIN Carrera_Estudiante ce ON e.dni = ce.dni " +
            "JOIN Carrera c ON ce.id_carrera = c.id_carrera " +
            "WHERE e.ciudad = :ciudad AND ce.id_carrera = :id_carrera")
    public List<Estudiante> getEstudiantesPorCarreraYCiudad(@Param("id_carrera") Long id_carrera, @Param("ciudad") String ciudad);//usar id carrera 1 y ciudad Chilly-Mazarin como ejemplo

}
