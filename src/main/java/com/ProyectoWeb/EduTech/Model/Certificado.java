package com.ProyectoWeb.EduTech.Model;
import jakarta.persistence.*;

@Entity
public class Certificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCertificado;

    @Column(nullable = false, unique = true, length = 50)
    private String codigoUnico;

    @OneToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idCurso", unique = true, nullable = false)
    private Curso curso;

    public Certificado() {
    }

    public Integer getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(Integer idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
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

