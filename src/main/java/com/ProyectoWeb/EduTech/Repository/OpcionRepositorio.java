package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpcionRepositorio extends JpaRepository<Opcion, Integer> {
    // Métodos de consulta personalizados si es necesario
}
