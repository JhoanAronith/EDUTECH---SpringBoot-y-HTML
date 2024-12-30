package com.ProyectoWeb.EduTech.Model;

import java.util.List;

public class PreguntaDTO {

    private String pregunta;
    private List<OpcionDTO> opciones;

    // Getters y Setters
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<OpcionDTO> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionDTO> opciones) {
        this.opciones = opciones;
    }

    public PreguntaDTO() {
    }
    
    
    
}
