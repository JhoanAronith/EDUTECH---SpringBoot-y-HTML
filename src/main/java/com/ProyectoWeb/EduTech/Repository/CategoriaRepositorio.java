package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
    
}
