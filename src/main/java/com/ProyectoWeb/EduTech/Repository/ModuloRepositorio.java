package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.Modulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ModuloRepositorio extends JpaRepository<Modulo, Integer> {

    @Query("SELECT m FROM Modulo m WHERE m.curso.idCurso = :cursoId")
    List<Modulo> findByCursoId(@Param("cursoId") Integer cursoId);
    
}
