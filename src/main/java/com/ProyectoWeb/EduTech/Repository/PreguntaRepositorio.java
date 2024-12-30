package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Integer> {
    // Métodos de consulta personalizados si es necesario
}
