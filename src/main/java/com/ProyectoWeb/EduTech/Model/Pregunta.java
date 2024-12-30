package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPregunta;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String pregunta;

    @ManyToOne
    @JoinColumn(name = "idExamen", nullable = false)
    private Examen examen;

    public Pregunta() {
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    
    
    
}
