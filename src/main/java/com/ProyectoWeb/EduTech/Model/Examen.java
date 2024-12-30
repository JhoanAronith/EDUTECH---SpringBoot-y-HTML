package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Double notaMinima;

    @OneToOne
    @JoinColumn(name = "idCurso", unique = true, nullable = false)
    private Curso curso;

    public Examen() {
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
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

    public Double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Double notaMinima) {
        this.notaMinima = notaMinima;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
}
