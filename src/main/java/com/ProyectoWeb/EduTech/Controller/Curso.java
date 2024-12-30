package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.*;
import com.ProyectoWeb.EduTech.Repository.*;
import com.ProyectoWeb.EduTech.Service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
public class Curso {

    @Autowired
    private CursoService cursoServicio;

    @Autowired
    private ModuloServicio moduloServicio;

    @Autowired
    private ExamenService examenServicio;

    @Autowired
    private PreguntaService preguntaServicio;

    @Autowired
    private OpcionService opcionServicio;

    @Autowired
    private CategoriaRepositorio catRepo;

    @Autowired
    private CursoRepositorio cursoRepo;

    @Autowired
    private ExamenRepositorio examenRepo;

    // Mostrar ventana para agregar curso
    @GetMapping("/administrador/nuevoCurso")
    public String verNuevoCurso(Model model) {
        model.addAttribute("catDTO", new CategoriaDTO());
        model.addAttribute("cursoDTO", new CursoDTO());
        model.addAttribute("moduloDTO", new ModuloDTO());
        model.addAttribute("examenDTO", new ExamenDTO());
        model.addAttribute("preguntaDTO", new PreguntaDTO());
        model.addAttribute("opcionDTO", new OpcionDTO());
        model.addAttribute("categorias", catRepo.findAll());
        model.addAttribute("cursos", cursoRepo.findAll());
        model.addAttribute("examenes", examenRepo.findAll());
        return "admin/nuevoCurso";
    }



    // Agregar nuevo examen con preguntas y opciones
    @PostMapping("/administrador/nuevoExamenCompleto")
    public String registrarExamenCompleto(Model model, @Valid @ModelAttribute ExamenDTO examenDTO, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            model.addAttribute("examenes", examenRepo.findAll());
            return "admin/nuevoCurso";
        }

        try {
            Examen examen = examenServicio.registrarExamen(examenDTO);
            for (PreguntaDTO preguntaDTO : examenDTO.getPreguntas()) {
                Pregunta pregunta = preguntaServicio.registrarPregunta(preguntaDTO, examen);
                for (OpcionDTO opcionDTO : preguntaDTO.getOpciones()) {
                    opcionServicio.registrarOpcion(opcionDTO, pregunta);
                }
            }
            model.addAttribute("examenDTO", new ExamenDTO());
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            model.addAttribute("examenes", examenRepo.findAll());
            model.addAttribute("successExamenCompleto", true);
        } catch (Exception ex) {
            result.addError(new FieldError("examenDTO", "nombre", ex.getMessage()));
            model.addAttribute("categorias", catRepo.findAll());
            model.addAttribute("cursos", cursoRepo.findAll());
            model.addAttribute("examenes", examenRepo.findAll());
            return "admin/nuevoCurso";
        }

        return "redirect:/administrador/nuevoCurso";
    }
}
