package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.*;
import com.ProyectoWeb.EduTech.Repository.CategoriaRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepositorio catRepo;

    // Agregar nueva categoría
    @PostMapping("/administrador/nuevaCategoria")
    public String registrarCategoria(Model model, @Valid @ModelAttribute CategoriaDTO catDTO, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("categorias", catRepo.findAll());
            return "admin/nuevoCurso";
        }

        try {
            Categoria nuevaCat = new Categoria();
            nuevaCat.setNombre(catDTO.getNombre());
            catRepo.save(nuevaCat);
            model.addAttribute("catDTO", new CategoriaDTO());
            model.addAttribute("successCategoria", true);
        } catch (Exception ex) {
            result.addError(new FieldError("catDTO", "nombre", ex.getMessage()));
            model.addAttribute("categorias", catRepo.findAll());
            return "admin/nuevoCurso";
        }

        return "redirect:/administrador/nuevoCurso";
    }

}
