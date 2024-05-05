package com.example.integrador_3.utils;

import com.example.integrador_3.models.Carrera;
import com.example.integrador_3.models.CarreraEstudiantePorDni;
import com.example.integrador_3.models.Carrera_Estudiante;
import com.example.integrador_3.repositories.CarreraEstudianteRepo;
import com.example.integrador_3.repositories.CarreraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import com.example.integrador_3.models.Estudiante;
import com.example.integrador_3.repositories.EstudianteRepo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {

    private final CarreraEstudianteRepo ceRepo;
    private final CarreraRepo carreraRepo;
    private final EstudianteRepo estudianteRepo;

    @Autowired
    public CargaDeDatos(CarreraEstudianteRepo ceRepo, CarreraRepo carreraRepo, EstudianteRepo estudianteRepo) {
        this.ceRepo = ceRepo;
        this.carreraRepo = carreraRepo;
        this.estudianteRepo = estudianteRepo;
    }

    public void cargarDatosEstudiantesDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador_3/csv/estudiantes.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Long.valueOf(csvRecord.get("DNI")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setLibretaUniversitaria(Long.valueOf(csvRecord.get("LU")));
                estudianteRepo.save(estudiante); // Guarda el Estudiante en la base de datos
            }
        }
    }

    public void cargarDatosCEDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador_3/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                CarreraEstudiantePorDni id = new CarreraEstudiantePorDni(
                        Long.valueOf(csvRecord.get("id_carrera")),
                        Long.valueOf(csvRecord.get("id_estudiante"))
                );

                Carrera_Estudiante ce = new Carrera_Estudiante();
                ce.setId(id);
                ce.setId_registro(Long.valueOf(csvRecord.get("id")));
                ce.setFecha_inscripcion(Integer.valueOf(csvRecord.get("inscripcion")));
                ce.setFecha_graduacion(Integer.valueOf(csvRecord.get("graduacion")));
                ce.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));

                ceRepo.save(ce); // Guarda el CarreraEstudiante en la base de datos
            }
        }
    }

    public void cargarDatosCarreraDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/integrador_3/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setId_carrera(Long.valueOf(csvRecord.get("id_carrera")));
                carrera.setNombre(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                carreraRepo.save(carrera); // Guarda la carrera en la base de datos
            }
        }
    }

}

