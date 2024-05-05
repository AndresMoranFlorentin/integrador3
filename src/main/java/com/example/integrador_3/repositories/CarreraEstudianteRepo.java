package com.example.integrador_3.repositories;

import com.example.integrador_3.models.Carrera_Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraEstudianteRepo extends JpaRepository<Carrera_Estudiante, Long> {

}
