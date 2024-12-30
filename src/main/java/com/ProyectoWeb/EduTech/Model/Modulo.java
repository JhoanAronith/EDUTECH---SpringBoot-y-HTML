package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModulo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Integer orden;

    private String enlaceVideo;
    private String enlacePDF;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    public Modulo() {
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
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

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getEnlaceVideo() {
        return enlaceVideo;
    }

    public void setEnlaceVideo(String enlaceVideo) {
        this.enlaceVideo = enlaceVideo;
    }

    public String getEnlacePDF() {
        return enlacePDF;
    }

    public void setEnlacePDF(String enlacePDF) {
        this.enlacePDF = enlacePDF;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    
}
