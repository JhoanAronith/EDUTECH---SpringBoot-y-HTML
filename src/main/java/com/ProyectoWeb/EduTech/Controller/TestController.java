package com.ProyectoWeb.EduTech.Controller;

import com.ProyectoWeb.EduTech.Model.CategoriaDTO;
import com.ProyectoWeb.EduTech.Model.CursoDTO;
import com.ProyectoWeb.EduTech.Repository.CategoriaRepositorio;
import com.ProyectoWeb.EduTech.Repository.CursoRepositorio;
import com.ProyectoWeb.EduTech.Service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private CursoService cursoServicio;

    @Autowired
    private CursoRepositorio cursoRepo;
    
    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cursos")
    public String cursos(Model model) {
        List<com.ProyectoWeb.EduTech.Model.Curso> cursos = cursoServicio.listarTodosConCategoria();

        model.addAttribute("cursos", cursos);

        CursoDTO cursoDTO = new CursoDTO();
        model.addAttribute(cursoDTO);
        model.addAttribute("success", false);
        return "cursos";
    }

    

}
