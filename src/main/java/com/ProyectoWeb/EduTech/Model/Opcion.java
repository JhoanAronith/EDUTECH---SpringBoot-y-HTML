package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOpcion;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String opcion;

    @Column(nullable = false)
    private Boolean correcta;

    @ManyToOne
    @JoinColumn(name = "idPregunta", nullable = false)
    private Pregunta pregunta;

    public Opcion() {
    }

    public Integer getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    
    
}
