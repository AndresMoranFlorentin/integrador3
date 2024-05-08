package com.example.integrador_3;

import com.example.integrador_3.utils.CargaDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Integrador3Application {

    @Autowired
    private CargaDeDatos cargaDeDatos;

    public static void main(String[] args) {
        SpringApplication.run(Integrador3Application.class, args);

    }
    @PostConstruct
    public void init() throws IOException {
        cargaDeDatos.cargarDatosEstudiantesDesdeCSV();
        cargaDeDatos.cargarDatosCarreraDesdeCSV();
        cargaDeDatos.cargarDatosCEDesdeCSV();
    }
}
