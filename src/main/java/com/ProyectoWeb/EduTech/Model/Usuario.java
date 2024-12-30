package com.ProyectoWeb.EduTech.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    //idUsuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    //nombre
    @Column
    private String nombre;
    
    //apellido
    @Column
    private String apellido;
    
    //dni
    @Column(unique=true)
    private String dni;
    
    //email
    @Column(unique=true, nullable=false)
    private String email;
    
    //password
    @Column
    private String password;
    
    //rol
    @Column
    private String rol;

    //Constructor vacío
    public Usuario() {
    }
    
    
    //Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    
}
