package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
public class RegistroCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    public RegistroCurso() {
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
}
