package com.ProyectoWeb.EduTech.Model;

public class ModuloDTO {

    private String nombre;
    private String descripcion;
    private Integer orden;
    private String enlaceVideo;
    private String enlacePDF;
    private Integer cursoId;

    // Getters y Setters
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

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
}
