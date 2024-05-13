package com.example.integrador_3.views;

import lombok.Getter;

import java.io.Serializable;
@Getter
    public class ReporteTdo implements Serializable {
        private String nombre;
        private int anio;
        private Long inscriptos;
        private Long egresados;
        public ReporteTdo(String nombre, int anio, Long inscriptos, Long egresados) {
            this.nombre = nombre;
            this.anio = anio;
            this.inscriptos = inscriptos;
            this.egresados = egresados;
        }
}
