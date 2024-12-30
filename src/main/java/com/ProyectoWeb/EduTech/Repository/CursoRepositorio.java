package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CursoRepositorio extends JpaRepository<Curso, Integer> {

    @Query("SELECT c FROM Curso c JOIN FETCH c.categoria")
    List<Curso> findAllWithCategoria();

}
