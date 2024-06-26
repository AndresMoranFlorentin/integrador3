package com.example.integrador_3.repositories;

import com.example.integrador_3.models.CarreraEstudiantePorDni;
import com.example.integrador_3.models.Carrera_Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CarreraEstudianteRepo")
public interface CarreraEstudianteRepo extends JpaRepository<Carrera_Estudiante, CarreraEstudiantePorDni> {

}
