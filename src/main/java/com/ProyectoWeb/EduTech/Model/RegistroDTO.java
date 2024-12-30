package com.ProyectoWeb.EduTech.Model;

import jakarta.validation.constraints.*;

public class RegistroDTO {
    
    //nombre
    @NotEmpty(message = "Ingrese su nombre.")
    private String nombre;
    
    //apellido
    @NotEmpty(message = "Ingrese su apellido.")
    private String apellido;
    
    //dni
    @NotEmpty(message = "Ingrese su DNI.")
    @Size(max = 8)
    private String dni;
   
    //email
    @NotEmpty(message = "Ingrese su dirección de correo electrónico.")
    @Email
    private String email;
    
    //password
    @Size(min=6, message="La contraseña debe tener 6 caracteres.")
    private String password;
    
    private String confirmPassword;

    private String rol;
    
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    

    
}
