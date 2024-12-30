package com.ProyectoWeb.EduTech.Model;

import java.util.List;

public class ExamenDTO {

    private String nombre;
    private String descripcion;
    private String notaMinima;
    private Integer cursoId;
    private List<PreguntaDTO> preguntas;

    public ExamenDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(String notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public List<PreguntaDTO> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaDTO> preguntas) {
        this.preguntas = preguntas;
    }
    
    

}
