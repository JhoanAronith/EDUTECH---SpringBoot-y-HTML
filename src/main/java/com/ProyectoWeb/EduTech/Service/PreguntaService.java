package com.ProyectoWeb.EduTech.Service;

import com.ProyectoWeb.EduTech.Model.Pregunta;
import com.ProyectoWeb.EduTech.Model.PreguntaDTO;
import com.ProyectoWeb.EduTech.Model.Examen;
import com.ProyectoWeb.EduTech.Repository.PreguntaRepositorio;
import com.ProyectoWeb.EduTech.Repository.ExamenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    @Autowired
    private ExamenRepositorio examenRepositorio;

    public Pregunta registrarPregunta(PreguntaDTO preguntaDTO, Examen examen) {
        Pregunta pregunta = new Pregunta();
        pregunta.setPregunta(preguntaDTO.getPregunta());
        pregunta.setExamen(examen);

        return preguntaRepositorio.save(pregunta);
    }
}
