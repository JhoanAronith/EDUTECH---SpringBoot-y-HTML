package com.ProyectoWeb.EduTech.Repository;

import com.ProyectoWeb.EduTech.Model.RegistroCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistroCursoRepositorio extends JpaRepository<RegistroCurso, Integer> {

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM RegistroCurso r WHERE r.usuario.idUsuario = :usuarioId AND r.curso.idCurso = :cursoId")
    boolean existsByUsuarioIdAndCursoId(@Param("usuarioId") Integer usuarioId, @Param("cursoId") Integer cursoId);
}
