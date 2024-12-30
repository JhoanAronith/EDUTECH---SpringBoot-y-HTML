package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Examen;
import com.ProyectoWeb.EduTech.Model.ExamenDTO;
import com.ProyectoWeb.EduTech.Model.Curso;
import com.ProyectoWeb.EduTech.Repository.ExamenRepositorio;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepositorio examenRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public Examen registrarExamen(ExamenDTO examenDTO) {
        Curso curso = cursoRepositorio.findById(examenDTO.getCursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));

        Examen examen = new Examen();
        examen.setNombre(examenDTO.getNombre());
        examen.setDescripcion(examenDTO.getDescripcion());
        examen.setNotaMinima(Double.parseDouble(examenDTO.getNotaMinima()));
        examen.setCurso(curso);

        return examenRepositorio.save(examen);
    }
}
