package com.example.integrador_3.repositories;

import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.views.EstudianteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepo extends JpaRepository<Estudiante, Long> {
    @Query("SELECT e FROM Estudiante e WHERE e.libretaUniversitaria=:lib")
    public Estudiante getEstudiantePorNumLibreta(Long lib);

    @Query("SELECT e FROM Estudiante e WHERE e.genero =: generoE")
    public List<EstudianteDto> getEstudiantePorGenero(String generoE);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido DESC")
    public List<Estudiante> getEstudiantesPorOrdenDelApellido();

    @Query("SELECT e FROM Estudiante e JOIN Carrera_Estudiante ce JOIN Carrera ca WHERE (e.dni=ce.id.dni) AND (ce.id.idCarrera =:id_carrera) AND (e.ciudad =:ciudad)")
    public List<EstudianteDto> getEstudiantesPorCarreraYCiudad(Long id_carrera, String ciudad);

    @Query("SELECT e FROM Estudiante e WHERE e.genero =: genero")
    List<Estudiante> findByGenero(String genero);
}
