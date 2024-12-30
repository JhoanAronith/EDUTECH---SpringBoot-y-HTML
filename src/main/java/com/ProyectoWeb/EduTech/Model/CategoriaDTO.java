package com.ProyectoWeb.EduTech.Model;

import jakarta.validation.constraints.*;

public class CategoriaDTO {
    
    //nombre categoria
    @NotEmpty(message = "Ingrese la categoria.")
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
