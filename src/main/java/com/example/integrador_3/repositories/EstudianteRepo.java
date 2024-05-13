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

    @Query("SELECT e FROM Estudiante e WHERE e.libretaUniversitaria=:lib")
    public Estudiante getEstudiantePorNumLibreta(Long lib);

    @Query("SELECT e FROM Estudiante e ORDER BY e.apellido DESC")
    public List<Estudiante> getEstudiantesPorOrdenDelApellido();

    @Query(nativeQuery = true,
            value = "   SELECT DISTINCT e.* FROM Estudiante e JOIN Carrera_Estudiante ce JOIN Carrera c " +
                    "    WHERE(e.dni=ce.dni) AND(e.ciudad=:ciudad) AND(ce.id_carrera=:id_carrera)")
    public List<Estudiante> getEstudiantesPorCarreraYCiudad(@Param("id_carrera") Long id_carrera, @Param("ciudad") String ciudad);

    //usar id carrera 1 y ciudad Chilly-Mazarin como ejemplo

}
