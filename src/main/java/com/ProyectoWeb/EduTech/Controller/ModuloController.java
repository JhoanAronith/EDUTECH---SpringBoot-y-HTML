package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.Modulo;
import com.ProyectoWeb.EduTech.Model.ModuloDTO;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import com.ProyectoWeb.EduTech.Service.ModuloServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ModuloController {

    @Autowired
    private ModuloServicio moduloServicio;

    @Autowired
    private CursoRepositorio cursoRepo;

    // Agregar nuevo módulo
    @PostMapping("/administrador/nuevoModulo")
    public String registrarModulo(Model model, @Valid @ModelAttribute ModuloDTO moduloDTO, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("cursos", cursoRepo.findAll());
            return "admin/nuevoCurso";
        }

        try {
            moduloServicio.registrarModulo(moduloDTO);
            model.addAttribute("moduloDTO", new ModuloDTO());
            model.addAttribute("cursos", cursoRepo.findAll());
            model.addAttribute("successModulo", true);
        } catch (Exception ex) {
            result.addError(new FieldError("moduloDTO", "nombre", ex.getMessage()));
            model.addAttribute("cursos", cursoRepo.findAll());
            return "admin/nuevoCurso";
        }

        return "redirect:/administrador/nuevoCurso";
    }

    @GetMapping("/administrador/cursos/{cursoId}/modulos")
    public String listarModulosPorCurso(@PathVariable Integer cursoId, Model model) {
        List<Modulo> modulos = moduloServicio.listarModulosPorCursoId(cursoId);
        List<com.ProyectoWeb.EduTech.Model.Curso> cursos = cursoRepo.findAll();
        model.addAttribute("cursos", cursos);
        model.addAttribute("modulos", modulos);
        model.addAttribute("cursoSeleccionadoId", cursoId);
        return "admin/cursos";
    }

}
